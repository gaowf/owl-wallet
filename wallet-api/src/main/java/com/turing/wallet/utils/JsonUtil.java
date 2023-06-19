package com.turing.wallet.utils;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonUtil {

    public static String toJson(Object object) {
        return JSON.toJSONString(object);
    }


    public static String toLogJson(Object object) {
        return JsonUtil.toJson(object);
    }

    public static <T> T toObject(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    public static <T> T object2Object(Object object, Class<T> clazz) {
        String json = toJson(object);
        return toObject(json, clazz);
    }

    public static boolean isValid(String json) {
        return JSON.isValid(json);
    }

}
