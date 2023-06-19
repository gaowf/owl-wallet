package com.turing.wallet.controller.auth;

import static com.turing.wallet.constants.Const.EXCH_SIGNATURE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.alibaba.fastjson.JSONObject;
import com.turing.wallet.controller.BaseControllerTests;
import com.google.common.hash.Hashing;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Map;
import javax.crypto.spec.SecretKeySpec;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

/**
 *
 */
public class AuthControllerTests extends BaseControllerTests {
    @Test
    void testAccessToken() throws Exception {
        String appId = "1597200152";
        String redirectUrl = "https://www.google.com";
        String timestamp = String.valueOf(Instant.now().toEpochMilli() / 1000);

        StringBuilder signParams = new StringBuilder();
        signParams
                .append("appId=")
                .append(appId)
                .append("&redirectUrl=")
                .append(redirectUrl)
                .append("&timestamp=")
                .append(timestamp);

        Map<String, String> params =
                paramsBuilder
                        .put("appId", appId)
                        .put("redirectUrl", redirectUrl)
                        .put("timestamp", timestamp)
                        .put("sign", sign(signParams))
                        .build();

        String sign = sign(params);

        httpHeaders.add(EXCH_SIGNATURE, sign);

        mockMvc
                .perform(
                        post("/v2/user/access_token")
                                .headers(httpHeaders)
                                .content(JSONObject.toJSONString(params))
                                .contentType(MediaType.APPLICATION_JSON)
                                .characterEncoding(encoding))
                .andDo(print())
                .andExpect(status().isOk());
    }

    private String sign(StringBuilder params) {
        SecretKeySpec secretKeySpec = null;
        try {
            secretKeySpec =
                    new SecretKeySpec(
                            "from web comics to React core with Rachel Nabors".getBytes("UTF-8"), "HmacSHA256");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String sign =
                Hashing.hmacSha256(secretKeySpec)
                        .hashString(params.toString(), StandardCharsets.UTF_8)
                        .toString();

        return sign;
    }
}
