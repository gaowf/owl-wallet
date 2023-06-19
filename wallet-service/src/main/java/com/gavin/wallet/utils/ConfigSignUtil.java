package com.turing.wallet.utils;

import com.alibaba.fastjson.JSONObject;
import com.turing.wallet.config.SignConfig;
import io.netty.util.internal.StringUtil;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.TreeMap;

public class ConfigSignUtil {

    protected static org.slf4j.Logger logger = LoggerFactory.getLogger(ConfigSignUtil.class);

    private static final String SUCC = "200";
    private static final String ENC = "/open/sign/en";
    private static final String DEC = "/open/sign/dec";

    public static String sendDec(
            String pwd, String server, String time, SignConfig signConfig) {
        final String signUrl = signConfig.getSys_server_sign_url();

        Map<String, String> paramMap = new TreeMap<>();
        paramMap.put("pwd", pwd);
        paramMap.put("server", server);
        paramMap.put("time", time);

        // 参数签名
        createParamsSign(paramMap, signConfig.getSys_server_sign_key());

        HttpClientUtil clientUtil = HttpClientUtil.getInstance();
        String jsonResult = clientUtil.doPostWithJsonResult(signUrl + DEC, paramMap);
        return parseResult(jsonResult);
    }

    private static String parseResult(String jsonResult) {
        if (StringUtil.isNullOrEmpty(jsonResult)) {
            return null;
        }
        JSONObject jsb = JSONObject.parseObject(jsonResult);
        if (jsb.containsKey("status")) {
            String status = jsb.getString("status");
            if (status.equals(SUCC)) {
                if (jsb.containsKey("msg")) {
                    return jsb.getString("msg");
                }
            } else {
                logger.error("请求解析异常：" + jsonResult);
            }
        }
        return null;
    }

    private static void createParamsSign(Map<String, String> paramMap, String signKey) {
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, String> et : paramMap.entrySet()) {
            sb.append(et.getKey() + "_" + et.getValue());
        }

        String md5 = MD5Util.getMD5(sb.toString() + signKey);
        paramMap.put("sign", md5);
    }
}
