package com.turing.wallet.utils;

import java.math.BigDecimal;

import lombok.extern.slf4j.Slf4j;

/**
 * 余额精确方法写在这里
 *
 * @author zhongjingyun
 */

/**
 * @author 鲫鱼哥 DateTime:2018年8月30日 下午7:15:58
 */
@Slf4j
public class ScaleUtils {
    public static final int BALANCE_ROUND_NUM_TWO = 2;
    public static final int BALANCE_ROUND_NUM_EIGHT = 8;
    public static final int BALANCE_ROUND_NUM_THREE = 3;
    public static final int BALANCE_ROUND_NUM_FOUR = 4;

    public static BigDecimal scaleByEight(BigDecimal balance) {
        if (balance == null || balance.compareTo(new BigDecimal(0)) == 0) {
            return new BigDecimal("0.00000000");
        }
        return balance.setScale(BALANCE_ROUND_NUM_EIGHT, BigDecimal.ROUND_DOWN);
    }

    public static String scaleByEightAsString(BigDecimal balance) {
        if (balance == null || balance.compareTo(new BigDecimal(0)) == 0) {
            return new BigDecimal("0.00000000").stripTrailingZeros().toPlainString();
        }
        return balance
                .setScale(BALANCE_ROUND_NUM_EIGHT, BigDecimal.ROUND_DOWN)
                .stripTrailingZeros()
                .toPlainString();
    }

    public static BigDecimal scaleByTwo(BigDecimal balance) {
        if (balance == null || balance.compareTo(new BigDecimal(0)) == 0) {
            return new BigDecimal("0.00");
        }
        return balance.setScale(BALANCE_ROUND_NUM_TWO, BigDecimal.ROUND_DOWN);
    }

    public static String scaleByTwoAsString(BigDecimal balance) {
        if (balance == null || balance.compareTo(new BigDecimal(0)) == 0) {
            return new BigDecimal("0.00").stripTrailingZeros().toPlainString();
        }
        return balance
                .setScale(BALANCE_ROUND_NUM_TWO, BigDecimal.ROUND_DOWN)
                .stripTrailingZeros()
                .toPlainString();
    }
}
