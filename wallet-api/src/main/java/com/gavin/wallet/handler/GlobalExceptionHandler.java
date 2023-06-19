package com.turing.wallet.handler;

import com.turing.wallet.enums.ApiResultType;
import com.turing.wallet.exception.CustomException;
import com.turing.wallet.wrapper.ResponseWrapper;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 异常处理.
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 添加全局异常处理流程
     *
     * @param e 异常
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseWrapper> exceptionHandler(HttpServletRequest req, Exception e) {
        log.error("error {}", ExceptionUtils.getStackTrace(e));

        if (e instanceof UndeclaredThrowableException) {
            UndeclaredThrowableException undeclaredThrowableException = (UndeclaredThrowableException) e;
            Throwable undeclaredThrowable = undeclaredThrowableException.getUndeclaredThrowable();
            if (undeclaredThrowable instanceof CustomException) {
                return ResponseEntity.ok(
                        ResponseWrapper.fail()
                                .code(((CustomException) undeclaredThrowable).getCode())
                                .message(undeclaredThrowable.getMessage())
                                .build());
            }
        }

        if (e instanceof CustomException) {
            return ResponseEntity.ok(
                    ResponseWrapper.fail()
                            .code(((CustomException) e).getCode())
                            .message(e.getMessage())
                            .build());
        }

        ObjectError objectError = null;
        if (e instanceof MethodArgumentNotValidException) {
            // 每次提示一个
            objectError = ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors().get(0);
        } else if (e instanceof BindException) {
            objectError = ((BindException) e).getBindingResult().getAllErrors().get(0);
        } else if (e instanceof MissingServletRequestParameterException) {
            String msg = String.format("`%s`%s", ((MissingServletRequestParameterException) e).getParameterName(), e.getMessage());
            return ResponseEntity.ok(
                    ResponseWrapper.fail().code(String.valueOf(ApiResultType.SystemError.getCode())).message(msg).build());
        } else if (e instanceof ConstraintViolationException) {
            Optional<ConstraintViolation<?>> firstOptional = ((ConstraintViolationException) e).getConstraintViolations().stream().findFirst();
            if (!firstOptional.isPresent()) {
                return null;
            }
            ConstraintViolation<?> constraintViolation = firstOptional.get();
            String msg = String.format("`%s`%s", ((PathImpl) constraintViolation.getPropertyPath()).getLeafNode().getName(), e.getMessage());
            return ResponseEntity.ok(
                    ResponseWrapper.fail().code(String.valueOf(ApiResultType.SystemError.getCode())).message(msg).build());
        }

        if (objectError != null) {
            String code = objectError.getCode();
            String message = objectError.getDefaultMessage();

            return ResponseEntity.ok(
                    ResponseWrapper.fail().code(String.valueOf(code.hashCode())).message(message).build());
        }

        return ResponseEntity.ok(
                ResponseWrapper.fail()
                        .code(ApiResultType.SystemError.getCode())
                        .message(ApiResultType.SystemError.getMessage())
                        .build());
    }
}
