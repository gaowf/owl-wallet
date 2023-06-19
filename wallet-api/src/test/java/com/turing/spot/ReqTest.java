package com.turing.spot;

import cn.hutool.http.HttpRequest;
import com.turing.wallet.constants.Const;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

/**
 * @author liubaojun
 * @title
 * @description
 * @date 2020/10/27 7:22 下午
 */
@Slf4j
public class ReqTest {

    @Test
    public void expireTokenTest() {
        String json = "{\"app_id\":\"1597657007\",\"sign\":\"2f7defb54534275037a39b8514137c2b23135139\",\"timestamp\":\"1603790761\",\"token\":\"234343\",\"uid\":\"1234\"}";

        String result2 = HttpRequest.post("https://test-1.wbfutures.cc/api-x/spot/token/expire")
                .header(Const.TRUST_TOKEN, "2f7defb54534275037a39b8514137c2b23135139")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header("exch-token", "spotTest")
                .body(json)
                .execute().body();

        log.info(result2);
    }


}
