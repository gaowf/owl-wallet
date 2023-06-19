package com.turing.wallet.service.limit;

import static com.turing.wallet.constants.Const.EXCH_SIGNATURE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.alibaba.fastjson.JSONObject;
import com.turing.wallet.controller.BaseControllerTests;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

/**
 *
 */
public class QueryLimitServiceTests extends BaseControllerTests {
    @Test
    void testFindLoginPwdStepOne() throws Exception {
        Map<String, String> params = paramsBuilder.put("account", "account").build();

        String sign = sign(params);

        httpHeaders.add(EXCH_SIGNATURE, sign);

        for (int i = 0; i < 11; ++i) {
            mockMvc
                    .perform(
                            post("/v2/user/find/password/one")
                                    .headers(httpHeaders)
                                    .content(JSONObject.toJSONString(params))
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .characterEncoding(encoding)
                    )
                    .andDo(print())
                    .andExpect(status().isOk());
        }
    }
}
