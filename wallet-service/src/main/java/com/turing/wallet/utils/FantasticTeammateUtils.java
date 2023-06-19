package com.turing.wallet.utils;

import org.springframework.util.Assert;

/**
 * 神奇队友. 不明白为什么redis写个缓存会存成这样??
 */
public class FantasticTeammateUtils {
    private FantasticTeammateUtils() {
        //
    }

    public static String redis(String source) {
        Assert.hasText(source, "config must not be empty");
        return source.substring(1, source.length() - 1).replaceAll("\\\\n", "").replaceAll("\\\\", "");
    }
}
