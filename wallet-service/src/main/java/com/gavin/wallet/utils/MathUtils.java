package com.turing.wallet.utils;

import java.math.BigInteger;

public final class MathUtils {

    public static BigInteger pow(BigInteger value, int n) {
        for (int i = 0; i < n; i++) {
            value = value.multiply(BigInteger.valueOf(10));
        }
        return value;
    }

}
