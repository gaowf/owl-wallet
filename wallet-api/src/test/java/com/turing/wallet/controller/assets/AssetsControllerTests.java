package com.turing.wallet.controller.assets;

import static com.turing.wallet.constants.Const.EXCH_CLIENT_TYPE;
import static com.turing.wallet.constants.Const.EXCH_DEVICE_ID;
import static com.turing.wallet.constants.Const.EXCH_ID;
import static com.turing.wallet.constants.Const.EXCH_LANGUAGE;
import static com.turing.wallet.constants.Const.EXCH_SIGNATURE;
import static com.turing.wallet.constants.Const.EXCH_TIMESTAMP;
import static com.turing.wallet.constants.Const.EXCH_TOKEN;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.alibaba.fastjson.JSONObject;
import com.turing.wallet.controller.BaseControllerTests;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * 资产.
 */
public class AssetsControllerTests extends BaseControllerTests {

    @Test
    void testTransfer() throws Exception {
        Map<String, String> params =
                paramsBuilder
                        .put("fromType", "3")
                        .put("symbol", "USDT")
                        .put("toType", "2")
                        .put("amount", "1.2")
                        .build();

        httpHeaders.clear();

        httpHeaders.add(EXCH_TIMESTAMP, "1591624927");
        httpHeaders.add(EXCH_LANGUAGE, "zh_CN");

        httpHeaders.add(EXCH_CLIENT_TYPE, "iOS");
        httpHeaders.add(EXCH_TOKEN, "d03cb718184a07d8ba49127e96045d76d3c2cdaaaf52f7684efcec9cc0a24380");
        httpHeaders.add(EXCH_DEVICE_ID, "00000000-0000-0000-0000-000000000000");
        httpHeaders.add(EXCH_ID, "1");

        httpHeaders.add("Origin", "https://stackoverflow.com/");

        String sign = sign(params);

        httpHeaders.add(
                EXCH_SIGNATURE, sign);

        mockMvc
                .perform(
                        post("/v2/asset/transfer")
                                .headers(httpHeaders)
                                .content(JSONObject.toJSONString(params))
                                .contentType(MediaType.APPLICATION_JSON)
                                .characterEncoding(encoding))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testInfo() throws Exception {
        mockMvc
                .perform(
                        post("/v2/asset/info")
                                .headers(httpHeaders)
                                .contentType(MediaType.APPLICATION_JSON)
                                .characterEncoding(encoding))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Transactional
    @Rollback(value = false)
    @Test
    void testDoWithdraw() throws Exception {
        Map<String, String> params =
                paramsBuilder
                        .put("symbol", "ETH")
//            .put("amount", "0.0213")
                        .put("amount", "10")
                        .put("fee", "0.006")
                        .put("address", "0xa9f429f2ecf5c3356dcdba0991395e93b592303f")
                        .build();

        String sign = sign(params);

        httpHeaders.add(EXCH_SIGNATURE, sign);

        mockMvc
                .perform(
                        post("/v2/asset/doWithdraw")
                                .headers(httpHeaders)
                                .content(JSONObject.toJSONString(params))
                                .contentType(MediaType.APPLICATION_JSON)
                                .characterEncoding(encoding))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
