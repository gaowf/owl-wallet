package com.turing.wallet.aspect;

import com.coinbull.cacheclient.model.CacheUser;
import com.turing.wallet.annotation.LoginRequired;
import com.turing.wallet.constants.Const;
import com.turing.wallet.enums.ApiResultType;
import com.turing.wallet.exception.CustomException;
import com.turing.wallet.service.common.LanguageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Enumeration;

import static com.turing.wallet.constants.Const.*;

/**
 * 登录
 */
@Slf4j
@Aspect
@Component
public class LoginAspect {

    private final LanguageService languageService;

    private RedisTemplate redisTemplate;

    public LoginAspect(
            LanguageService languageService,
            RedisTemplate redisTemplate) {
        this.languageService = languageService;
        this.redisTemplate = redisTemplate;
    }

    @Around("@annotation(com.turing.wallet.annotation.LoginRequired)")
    public Object loginAspect(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();

        LoginRequired loginRequired = method.getAnnotation(LoginRequired.class);
        boolean login = loginRequired.value();

        if (!login) {
            return pjp.proceed();
        }

        checkLogin();

        return pjp.proceed();
    }

    private void checkLogin() throws CustomException, IOException {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String exchId = request.getHeader(EXCH_ID);
        String token = request.getHeader(EXCH_TOKEN);
        String requestURI = request.getRequestURI();
        if (StringUtils.isBlank(token)) {
            log.error("api {}, require token {} ", requestURI, logHeaders(request));
            throw new CustomException(ApiResultType.NotLogin.getCode(),languageService.multilingualTemplate(ApiResultType.NotLogin.getConfigKey()));
        }
        final String cacheKey = Const.TOKEN_USER + token;
        Object obj = redisTemplate.opsForValue().get(cacheKey);
        if (obj == null) {
            log.error("api {}, not login {} ", requestURI, logHeaders(request));
            throw new CustomException(ApiResultType.NotLogin.getCode(),languageService.multilingualTemplate(ApiResultType.NotLogin.getConfigKey()));
        }
        if (obj instanceof CacheUser) {
            request.setAttribute(CACHE_USER, (CacheUser)obj);
        }
    }

    private String logHeaders(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        StringBuilder logHeaders = new StringBuilder();
        while (headerNames.hasMoreElements()) {
            String s = headerNames.nextElement();
            String header = request.getHeader(s);
            logHeaders.append(s).append("=").append(header).append("\n");
        }
        return logHeaders.toString();
    }
}
