package com.turing.wallet.aspect;

import static com.turing.wallet.constants.Const.EXCH_CLIENT_TYPE;
import static com.turing.wallet.constants.Const.EXCH_DEVICE_ID;
import static com.turing.wallet.constants.Const.EXCH_ID;
import static com.turing.wallet.constants.Const.EXCH_LANGUAGE;
import static com.turing.wallet.constants.Const.EXCH_SIGNATURE;
import static com.turing.wallet.constants.Const.EXCH_TIMESTAMP;
import static com.turing.wallet.constants.Const.EXCH_TOKEN;
import static com.turing.wallet.constants.Const.SIGN_CONFIG;

import com.alibaba.fastjson.JSONObject;
import com.turing.wallet.annotation.SignRequired;
import com.turing.wallet.enums.ApiResultType;
import com.turing.wallet.dto.config.SignConfig;
import com.turing.wallet.exception.CustomException;
import com.turing.wallet.service.blackbox.BlackBoxService;
import com.turing.wallet.service.common.LanguageService;
import com.turing.wallet.utils.FantasticTeammateUtils;
import com.turing.wallet.utils.SignUtil;
import com.turing.wallet.wrapper.MultiReadHttpServletRequestWrapper;
import com.google.common.hash.Hashing;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 签名
 */
@Slf4j
@Aspect
@Component
public class SignAspect {
    private final LanguageService languageService;
    private final RedisTemplate<String, String> redisTemplate;
    private final BlackBoxService blackBoxService;

    public SignAspect(
            LanguageService languageService,
            RedisTemplate<String, String> redisTemplate,
            BlackBoxService blackBoxService) {
        this.languageService = languageService;
        this.redisTemplate = redisTemplate;
        this.blackBoxService = blackBoxService;
    }

    @Around("@annotation(com.turing.wallet.annotation.SignRequired)")
    public Object signAspect(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();

        SignRequired signRequired = method.getAnnotation(SignRequired.class);
        boolean sign = signRequired.value();

        if (!sign) {
            return pjp.proceed();
        }

        checkSign();

        return pjp.proceed();
    }

    private void checkSign() throws CustomException, IOException {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String signature = request.getHeader(EXCH_SIGNATURE);
        String exchId = request.getHeader(EXCH_ID);

        String token = request.getHeader(EXCH_TOKEN);
        if (StringUtils.isBlank(token)) {
            // 未登录
            return;
        }


        boolean enableSign = configCheck(exchId);
        // 签名测试地址 无条件校验
        final String checkURI = "/v2/sign/test";
        final String checkURI2 = "/v2/sign/test2";
        String requestURI = request.getRequestURI();
        if (StringUtils.isEmpty(signature)) {
            log.error("api {}, sign fail {} ", requestURI, logHeaders(request));
            if (enableSign || ((checkURI.equals(requestURI) || checkURI2.equals(requestURI))
                    && signTest(exchId))) {
                throw new CustomException(
                        ApiResultType.SignFail.getCode(),
                        languageService.multilingualTemplate(ApiResultType.SignFail.getConfigKey()));
            }
        }
        // 获取body(对应@RequestBody)
        String body = null;
        if (request instanceof MultiReadHttpServletRequestWrapper) {
            body = IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8);
        }

        // 获取parameters(对应@RequestParam)
        Map<String, String[]> params = null;
        if (!CollectionUtils.isEmpty(request.getParameterMap())) {
            params = request.getParameterMap();
        }
        //  paths 参数不参与签名

        try {
            String newSign = sign(request, body, params);
            if (!newSign.equals(signature)) {
                log.error(
                        "api {}, sign fail {} client sign {}, server sign {}",
                        requestURI,
                        logHeaders(request),
                        signature,
                        newSign);
                if (enableSign ||
                        ((checkURI.equals(requestURI)
                                || checkURI2.equals(requestURI))
                                && signTest(exchId))) {
                    throw new CustomException(
                            ApiResultType.SignFail.getCode(),
                            languageService.multilingualTemplate(ApiResultType.SignFail.getConfigKey()));
                }
            }
        } catch (Exception e) {
            log.error("api {}, sign fail {} ", requestURI, logHeaders(request));
            log.error("sign fail : {}", ExceptionUtils.getStackTrace(e));
            if (enableSign || ((checkURI.equals(requestURI)
                    || checkURI2.equals(requestURI)) && signTest(exchId))) {
                throw new CustomException(
                        ApiResultType.SignFail.getCode(),
                        languageService.multilingualTemplate(ApiResultType.SignFail.getConfigKey()));
            }
        }
    }

    private boolean signTest(String exchId) {
        try {
            String signConfig = redisTemplate.opsForValue().get(SIGN_CONFIG + ":" + exchId);
            if (StringUtils.isBlank(signConfig)) {
                return false;
            }
            SignConfig signConfigVo =
                    JSONObject.parseObject(FantasticTeammateUtils.redis(signConfig), SignConfig.class);
            return signConfigVo.isEnableSignTest();
        } catch (Exception e) {
            log.error("sign e : {}", ExceptionUtils.getStackTrace(e));
        }
        return false;
    }

    private boolean configCheck(String exchId) {
        try {
            String signConfig = redisTemplate.opsForValue().get(SIGN_CONFIG + ":" + exchId);
            if (StringUtils.isBlank(signConfig)) {
                return false;
            }
            SignConfig signConfigVo =
                    JSONObject.parseObject(FantasticTeammateUtils.redis(signConfig), SignConfig.class);
            return signConfigVo.isEnable();
        } catch (Exception e) {
            log.error("sign e : {}", ExceptionUtils.getStackTrace(e));
        }
        return false;
    }

    private String sign(HttpServletRequest request, String body, Map<String, String[]> params) {
        String exTimestamp = request.getHeader(EXCH_TIMESTAMP);
        String exId = request.getHeader(EXCH_ID);
        String exDeviceId = request.getHeader(EXCH_DEVICE_ID);
        String exLanguage = request.getHeader(EXCH_LANGUAGE);
        String exchSignature = request.getHeader(EXCH_SIGNATURE);
        String exchClientType = request.getHeader(EXCH_CLIENT_TYPE);
        String token = request.getHeader(EXCH_TOKEN);
        //    log.info(
        //        "exch-timestamp: {}, exch-id: {},exch-Device-ID: {}, exch-language: {},
        // exch-signature",
        //        exTimestamp,
        //        exId,
        //        exDeviceId,
        //        exLanguage,
        //        exchSignature);

        Map<String, String> signParams = new TreeMap<>();

        signParams.put(EXCH_TIMESTAMP, exTimestamp);
        signParams.put(EXCH_ID, exId);
        signParams.put(EXCH_DEVICE_ID, exDeviceId);
        signParams.put(EXCH_LANGUAGE, exLanguage);
        signParams.put(EXCH_CLIENT_TYPE, exchClientType);

        if (!StringUtils.isEmpty(body)) {
            signParams.putAll(JSONObject.parseObject(body, Map.class));
        }

        if (!CollectionUtils.isEmpty(params)) {
            params.entrySet().stream()
                    .forEach(
                            entry -> {
                                signParams.put(entry.getKey(), entry.getValue()[0]);
                            });
        }

        StringBuilder signParamsBuilder = new StringBuilder();
        for (Entry entry : signParams.entrySet()) {
            if (signParamsBuilder.length() == 0) {
                signParamsBuilder.append(entry.getKey()).append("=").append(entry.getValue());
            } else {
                signParamsBuilder.append("&").append(entry.getKey()).append("=").append(entry.getValue());
            }
        }
        // log.info("sign params {}", signParamsBuilder.toString());

        String devUUID = SignUtil.getSecret(token);// (String) redisTemplate.opsForHash().get(APP_DEVICE_TOKEN + exId, exDeviceId);
//    if (StringUtils.isEmpty(devUUID)) {
//      // 重试加载
//      devUUID = blackBoxService.reloadUUID(exId, exDeviceId);
//    }
        log.info("dev uuid {}", devUUID);
        if (StringUtils.isEmpty(devUUID)) {
            log.error("{} 设备号未初始化:{}", exId, exDeviceId);
            return "";
        }

        SecretKeySpec secretKeySpec = null;
        try {
            secretKeySpec = new SecretKeySpec(devUUID.getBytes("UTF-8"), "HmacSHA256");
        } catch (UnsupportedEncodingException e) {
            log.error("secret key spec {}", ExceptionUtils.getStackTrace(e));
            return "";
        }

        return Hashing.hmacSha256(secretKeySpec)
                .hashString(signParamsBuilder.toString(), StandardCharsets.UTF_8)
                .toString();
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
