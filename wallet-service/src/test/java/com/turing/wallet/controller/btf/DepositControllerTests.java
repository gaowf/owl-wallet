package com.turing.wallet.controller.btf;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.alibaba.fastjson.JSONObject;
import com.turing.wallet.controller.BaseControllerTests;
import com.turing.wallet.utils.SignUtil;
import com.google.common.collect.ImmutableMap;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
public class DepositControllerTests extends BaseControllerTests {
    @Transactional
    @Rollback(value = false)
    @Test
    void testDeposit() throws Exception {
        String timestamp = String.valueOf(Instant.now().toEpochMilli() / 1000);

        Map<String, String> params =
                new ImmutableMap.Builder<String, String>()
                        .put("app_id", "1597657007")
                        .put("timestamp", timestamp)
                        .put("symbol", "BLP")
                        .put("uid", "1275676468294324224")
                        .put("address_to", "Y3j502p")
                        .put("tx_id", "BLP")
                        .put("amount", "10000")
                        .put("confirm", "6")
                        .build();

        String sign = SignUtil.sign(params, "Nobody has to lose in work/life balance");

        params = new HashMap<>(params);
        params.put("sign", sign);

        mockMvc
                .perform(
                        post("/btf/deposit")
                                .headers(httpHeaders)
                                .content(JSONObject.toJSONString(params))
                                .contentType(MediaType.APPLICATION_JSON)
                                .characterEncoding(encoding))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testAddressCheck() throws Exception {
        String timestamp = String.valueOf(Instant.now().toEpochMilli() / 1000);

        Map<String, String> params =
                new ImmutableMap.Builder<String, String>()
                        .put("app_id", "1597657007")
                        .put("timestamp", timestamp)
                        .put("symbol", "ABC")
                        .put("uid", "1275676468294324224")
                        .put("address_to", "P6J3jgm")
                        .build();

        String sign = SignUtil.sign(params, "Nobody has to lose in work/life balance");

        params = new HashMap<>(params);
        params.put("sign", sign);

        mockMvc
                .perform(
                        post("/btf/address/check")
                                .headers(httpHeaders)
                                .content(JSONObject.toJSONString(params))
                                .contentType(MediaType.APPLICATION_JSON)
                                .characterEncoding(encoding))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
