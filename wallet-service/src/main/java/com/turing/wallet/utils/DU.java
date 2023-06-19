package com.turing.wallet.utils;

import java.math.BigDecimal;

public class DU {
    /**
     * 加法运算
     *
     * @param m1
     * @param m2
     * @return
     */
    public static double add(double m1, double m2) {
        return BigDecimal.valueOf(m1).add(BigDecimal.valueOf(m2)).doubleValue();
    }

    /**
     * 减法运算
     *
     * @param m1
     * @param m2
     * @return
     */
    public static double subtract(double m1, double m2) {
        return BigDecimal.valueOf(m1).subtract(BigDecimal.valueOf(m2)).doubleValue();
    }

    /**
     * 乘法运算
     *
     * @param m1
     * @param m2
     * @return
     */
    public static double multiply(double m1, double m2) {
        return BigDecimal.valueOf(m1).multiply(BigDecimal.valueOf(m2)).doubleValue();
    }


    /**
     * 除法运算
     *
     * @param m1
     * @param m2
     * @return
     */
    public static double divide(double m1, double m2) {
        return BigDecimal.valueOf(m1).divide(BigDecimal.valueOf(m2), 8, BigDecimal.ROUND_HALF_DOWN).doubleValue();
    }

    /***
     * 去掉Double小数点后多余的0
     * @param s
     * @return
     */
    public static String removeZeroAndDot(String s) {
        if (s.isEmpty()) {
            return null;
        }
        if (s.indexOf(".") > 0) {
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }
}
