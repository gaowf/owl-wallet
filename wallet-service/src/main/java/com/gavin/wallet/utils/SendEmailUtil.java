package com.turing.wallet.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class SendEmailUtil{
    /**
     * 发送email
     */
    public static boolean sendMail(String from, String to, String subject, String content, String gateway) {
        Map<String, String> map = new HashMap<>();
        map.put("from", from);
        map.put("to", to);
        map.put("subject", subject);
        map.put("content", content);

        log.info("邮箱发送请求信息:{};gateway={}", JsonUtil.toJson(map), gateway);
        String result = HttpClientUtil.getInstance().doPostWithJsonResult( gateway, map);

        if (result != null) {
            return true;
        } else {
            return false;
        }
    }
}
