package com.turing.wallet.service.blackbox;

import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Collections;

/**
 * 黑盒服务.
 */
@Service
@Slf4j
public class BlackBoxServiceImpl implements BlackBoxService {
    /**
     * 黑盒域名.
     */
    @Value("${black.box.server-addr}")
    private String blackBoxHost;

    private final RestTemplate restTemplate;

    public BlackBoxServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public boolean withdrawFingerprint(
            Long id,
            String symbol,
            String addressTo,
            BigDecimal amount,
            BigDecimal fee,
            Long uid,
            Long time,
            String fingerprint) {

        try {

            HttpEntity<ImmutableMap<Object, Object>> request =
                    new HttpEntity<>(
                            ImmutableMap.builder()
                                    .put("id", id)
                                    .put("symbol", symbol)
                                    .put("addressTo", addressTo)
                                    .put("amount", amount.stripTrailingZeros().toPlainString())
                                    .put("fee", fee)
                                    .put("uid", uid)
                                    .put("time", time)
                                    .put("fingerprint", fingerprint)
                                    .build(),
                            getDefaultHeaders());
            // 添加提币指纹.
            String withdrawFingerprintMethod = "/finance/withdrawFingerprint";
            ResponseEntity<String> fingerprintResponse =
                    restTemplate.postForEntity(
                            blackBoxHost + withdrawFingerprintMethod, request, String.class);
            if (fingerprintResponse.getStatusCode() == HttpStatus.OK) {
                if (StringUtils.isBlank(fingerprintResponse.getBody())) {
                    return false;
                }
                return "true".equalsIgnoreCase(fingerprintResponse.getBody());
            }
        } catch (Exception e) {
            log.error("提币指纹添加失败 :{}", ExceptionUtils.getStackTrace(e));
        }

        return false;
    }

    @Override
    public String uuid(String exchDeviceId, String exchId, String ip, String deviceType) {
        final String api = "/device/uuid";
        ResponseEntity<String> exchange =
                restTemplate.exchange(
                        blackBoxHost + api,
                        HttpMethod.POST,
                        new HttpEntity<>(
                                ImmutableMap.builder()
                                        .put("deviceId", exchDeviceId)
                                        .put("exId", exchId)
                                        .put("ip", ip)
                                        .put("deviceType", deviceType)
                                        .build(),
                                getDefaultHeaders()),
                        String.class);
        String token = "";
        if (exchange.getStatusCode() == HttpStatus.OK) {
            token = exchange.getBody();
        }

        return token;
    }

    @Override
    public String passwordEncrypt(String password, long id, String exchId) {
        final String api = "/password/encrypt";
        ResponseEntity<String> encryptPasswordResponse =
                restTemplate.exchange(
                        blackBoxHost + api,
                        HttpMethod.POST,
                        new HttpEntity<>(
                                ImmutableMap.builder()
                                        .put("password", password)
                                        .put("id", id)
                                        .put("exchId", exchId)
                                        .build(),
                                getDefaultHeaders()),
                        String.class);
        if (encryptPasswordResponse.getStatusCode() == HttpStatus.OK) {
            return encryptPasswordResponse.getBody();
        }
        return null;
    }

    @Override
    public String passwordVerification(String password, String expected, long id, String exchId) {
        String api = "/password/verification";
        ResponseEntity<String> verifyResponse =
                restTemplate.exchange(
                        blackBoxHost + api,
                        HttpMethod.POST,
                        new HttpEntity<>(
                                ImmutableMap.builder()
                                        .put("password", password)
                                        .put("expected", expected)
                                        .put("id", id)
                                        .put("exchId", exchId)
                                        .build(),
                                getDefaultHeaders()),
                        String.class);
        if (verifyResponse.getStatusCode() == HttpStatus.OK) {
            return verifyResponse.getBody();
        }

        return null;
    }

    @Override
    public String updateLastDeviceUser(String deviceId, long userId, int exchId) {
        String api = "/device/last/user";
        ResponseEntity<String> verifyResponse =
                restTemplate.exchange(
                        blackBoxHost + api,
                        HttpMethod.POST,
                        new HttpEntity<>(
                                ImmutableMap.builder()
                                        .put("deviceId", deviceId)
                                        .put("userId", userId)
                                        .put("exId", exchId)
                                        .build(),
                                getDefaultHeaders()),
                        String.class);
        if (verifyResponse.getStatusCode() == HttpStatus.OK) {
            return verifyResponse.getBody();
        }

        return null;
    }

    @Override
    public String reloadUUID(String exId, String deviceId) {
        String api = "/device/uuid/reload";
        ResponseEntity<String> verifyResponse =
                restTemplate.exchange(
                        blackBoxHost + api,
                        HttpMethod.POST,
                        new HttpEntity<>(
                                ImmutableMap.builder().put("deviceId", deviceId).put("exId", exId).build(),
                                getDefaultHeaders()),
                        String.class);
        if (verifyResponse.getStatusCode() == HttpStatus.OK) {
            return verifyResponse.getBody();
        }

        return null;
    }

    @Override
    public String genInfoFingerprint(Long uid, String mobile, String email, String googleSecret) {
        log.info("gen user fingerprint -> uid={}", uid);
        String api = "/user/info/fingerprint";
        ResponseEntity<String> genInfoFingerprintResponse =
                restTemplate.exchange(
                        blackBoxHost + api,
                        HttpMethod.POST,
                        new HttpEntity<>(
                                ImmutableMap.builder()
                                        .put("uid", uid)
                                        .put("mobile", StringUtils.isBlank(mobile) ? "" : mobile)
                                        .put("email", StringUtils.isBlank(email) ? "" : email)
                                        .put("googleSecret", StringUtils.isBlank(googleSecret) ? "" : googleSecret)
                                        .put("fingerprint", "")
                                        .build(),
                                getDefaultHeaders()),
                        String.class);
        if (genInfoFingerprintResponse.getStatusCode() == HttpStatus.OK) {
            String genInfoFingerprint = genInfoFingerprintResponse.getBody();
            assert genInfoFingerprint != null;
            if (StringUtils.isNotBlank(genInfoFingerprint)) {
                return genInfoFingerprint;
            }
        }
        return "";
    }

    @Override
    public Boolean checkInfoFingerprint(Long uid, String mobile, String email, String googleSecret, String fingerprint) {
        String api = "/user/info/fingerprint/check";
        ResponseEntity<String> verifyResponse =
                restTemplate.exchange(
                        blackBoxHost + api,
                        HttpMethod.POST,
                        new HttpEntity<>(
                                ImmutableMap.builder()
                                        .put("uid", uid)
                                        .put("mobile", StringUtils.isBlank(mobile) ? "" : mobile)
                                        .put("email", StringUtils.isBlank(email) ? "" : email)
                                        .put("googleSecret", StringUtils.isBlank(googleSecret) ? "" : googleSecret)
                                        .put("fingerprint", StringUtils.isBlank(fingerprint) ? "" : fingerprint)
                                        .build(),
                                getDefaultHeaders()),
                        String.class);
        if (verifyResponse.getStatusCode() == HttpStatus.OK) {
            String checkInfoFingerprint = verifyResponse.getBody();
            assert checkInfoFingerprint != null;
            if (StringUtils.isNotBlank(checkInfoFingerprint)) {
                return Boolean.valueOf(checkInfoFingerprint);
            }
        }
        return false;
    }

    private HttpHeaders getDefaultHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Collections.singletonList(MediaType.ALL));
        return httpHeaders;
    }
}
