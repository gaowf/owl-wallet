package com.turing.wallet.controller.user;

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
public class UserInfoTests extends BaseControllerTests {
    @Test
    void testBaseInfo() throws Exception {
        Map<String, String> params = paramsBuilder.build();

        String sign = sign(params);

        httpHeaders.add(EXCH_SIGNATURE, sign);

        mockMvc
                .perform(
                        post("/v2/user/base/info")
                                .headers(httpHeaders)
                                .content(JSONObject.toJSONString(params))
                                .contentType(MediaType.APPLICATION_JSON)
                                .characterEncoding(encoding))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testUpdateUserBaseInfo() throws Exception {
        Map<String, String> params = paramsBuilder
                .put("userName", "中年胖子")
                .put("headImgUrl", "https://seopic.699pic.com/photo/40011/0709.jpg_wh1200.jpg")
                .put("introduction", "小胖子不蛮胖")
                .build();

        String sign = sign(params);

        httpHeaders.add(EXCH_SIGNATURE, sign);

        mockMvc
                .perform(
                        post("/v2/user/update/base/info")
                                .headers(httpHeaders)
                                .content(JSONObject.toJSONString(params))
                                .contentType(MediaType.APPLICATION_JSON)
                                .characterEncoding(encoding))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testInviter() throws Exception {
        Map<String, String> params = paramsBuilder
                .put("inviteCode", "EQLTVGVHHELHLWZQHZH")
                .build();

        String sign = sign(params);

        httpHeaders.add(EXCH_SIGNATURE, sign);

        mockMvc
                .perform(
                        post("/v2/user/inviter")
                                .headers(httpHeaders)
                                .content(JSONObject.toJSONString(params))
                                .contentType(MediaType.APPLICATION_JSON)
                                .characterEncoding(encoding))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
