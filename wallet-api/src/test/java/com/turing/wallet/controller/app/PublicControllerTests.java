package com.turing.wallet.controller.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.turing.wallet.controller.BaseControllerTests;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

/**
 * 公共接口.
 */
public class PublicControllerTests extends BaseControllerTests {

    @Test
    void testCommonData() throws Exception {
        mockMvc
                .perform(
                        get("/v2/public/common/data")
                                .headers(httpHeaders)
                                .contentType(MediaType.APPLICATION_JSON)
                                .characterEncoding(encoding))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testIp() throws Exception {
        mockMvc
                .perform(
                        get("/v2/public/ip")
                                .headers(httpHeaders)
                                .contentType(MediaType.APPLICATION_JSON)
                                .characterEncoding(encoding))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
