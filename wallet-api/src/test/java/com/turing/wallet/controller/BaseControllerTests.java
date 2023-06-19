package com.turing.wallet.controller;

import static com.turing.wallet.constants.Const.EXCH_CLIENT_TYPE;
import static com.turing.wallet.constants.Const.EXCH_DEVICE_ID;
import static com.turing.wallet.constants.Const.EXCH_ID;
import static com.turing.wallet.constants.Const.EXCH_LANGUAGE;
import static com.turing.wallet.constants.Const.EXCH_TIMESTAMP;
import static com.turing.wallet.constants.Const.EXCH_TOKEN;

import com.turing.wallet.constants.Const;
import com.turing.wallet.enums.Language;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.hash.Hashing;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import javax.crypto.spec.SecretKeySpec;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;

/**
 * base tests.
 */
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class BaseControllerTests {
    @Autowired
    protected MockMvc mockMvc;

    // 请求参数
    protected Builder<String, String> paramsBuilder;

    protected String encoding = "UTF-8";

    // 公共请求头
    protected HttpHeaders httpHeaders;

    protected String exTimestamp;

    protected String exId = "1";

    //  protected String exDeviceId = "Before-software-can-be-reusable-it-first-has-to-be-usable";
    protected String exDeviceId = "ffffffff-8d61-83d7-ffff-ffffef05ac4a";

    // protected String uuid = "8cdeb940eeb88f26304f9cd6ecdd58c14ab9db68d85cf930ed619dda680aabff";
    protected String uuid = "757f66355ca5f7580c711254632de5a661e997eddb59d68ef176e841875a6dc2";

    protected String token = "105570e8bff184bd9888e35069f90fde260486ca8db80d30bdf950da4c1fea28";

    protected String exLanguage = Language.English.getLangType();

    protected String exchClientType = Const.CLIENT_TYPE_ANDROID;

    @BeforeEach
    protected void init() {
        paramsBuilder = new Builder<>();

        httpHeaders = new HttpHeaders();

        exTimestamp = String.valueOf(OffsetDateTime.now(ZoneOffset.UTC).toEpochSecond());

        log.info(
                "exch-timestamp: {}, exch-id: {},exch-Device-ID: {}, exch-language: {}",
                exTimestamp,
                exId,
                exDeviceId,
                exLanguage);

        httpHeaders.add(EXCH_TIMESTAMP, exTimestamp);
        httpHeaders.add(EXCH_ID, exId);
        httpHeaders.add(EXCH_DEVICE_ID, exDeviceId);
        httpHeaders.add(EXCH_LANGUAGE, exLanguage);
        httpHeaders.add(EXCH_CLIENT_TYPE, exchClientType);
        httpHeaders.add(EXCH_TOKEN, token);
        httpHeaders.add("Origin", "https://stackoverflow.com/");
    }

    protected String sign(Map<String, String> params) {

        Map<String, String> signParams = new TreeMap<>(params);

        signParams.put(EXCH_TIMESTAMP, httpHeaders.getFirst(EXCH_TIMESTAMP));
        signParams.put(EXCH_ID, httpHeaders.getFirst(EXCH_ID));
        signParams.put(EXCH_DEVICE_ID, httpHeaders.getFirst(EXCH_DEVICE_ID));
        signParams.put(EXCH_LANGUAGE, httpHeaders.getFirst(EXCH_LANGUAGE));
        signParams.put(EXCH_CLIENT_TYPE, httpHeaders.getFirst(EXCH_CLIENT_TYPE));

        StringBuilder signParamsBuilder = new StringBuilder();
        for (Entry entry : signParams.entrySet()) {
            if (signParamsBuilder.length() == 0) {
                signParamsBuilder.append(entry.getKey()).append("=").append(entry.getValue());
            } else {
                signParamsBuilder.append("&").append(entry.getKey()).append("=").append(entry.getValue());
            }
        }
        log.info("sign params {}", signParamsBuilder.toString());

        String devUUID = uuid;
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
}
