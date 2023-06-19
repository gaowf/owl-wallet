package com.turing.wallet.utils;

import com.google.common.base.Strings;
import lombok.Builder;
import lombok.Data;

import java.util.Objects;
import java.util.Random;

/**
 * id 生成.
 */
public final class IdUtils {
    private IdUtils() {
        //
    }

    private static final int min = 100000000;
    private static final int max = 999999999;

    public static long nextId(int exchId) {
        String prefix = Strings.padEnd(String.valueOf(exchId), 3, '0');
        Random r = new Random();
        String suffix = "" + r.nextInt(max - min) + min;

        return Long.parseLong((prefix + suffix).substring(0, 12));
    }


    public static void main(String[] args) {
        System.out.println(nextId(1));
    }

    /**
     * uid 构成
     * 共计64位
     * 前8位预留
     * 业务标识8位 : 1位(标识是否为母子账户)+7位 交易所业务标识(0：exchange 1:broker )
     * 具体的交易所ID 16位
     * uid 32位：31位+1位随机数
     */

    public static int accountTypeLen = 55;

    public static int busTypeLen = 48;

    public static int uidLen = 32;

    public static Long uid0X = 0xFFFFFFFFL;

    /**
     * @param accountType  0 表示母账户  1表示子账户
     * @param exchangeType
     * @param exchangeId
     * @param userId
     * @return
     */
    public static Long generateUid(Long accountType,
                                   Long exchangeType,
                                   Long exchangeId,
                                   Long userId) {

        long accountTypeNum = accountType << accountTypeLen;
        long busTypeNum = exchangeType << busTypeLen;
        long busIdNum = exchangeId << uidLen;
        long result = accountTypeNum | busTypeNum | busIdNum | userId;
        return result;
    }

    public static UserIdVO parseUserId(Long uid) {
        long userId = uid & uid0X;
        long busId = (uid >> uidLen) & 0xFFFF;
        long busType = (uid >> busTypeLen) & 0x7F;
        long accountType = (uid >> accountTypeLen) & 0xF;
        return UserIdVO.builder()
                .userId(userId)
                .busId(busId)
                .busType((int) busType)
                .accountType((int) accountType)
                .build();
    }

    public static String parseUserId(String uid) {
        if (Objects.isNull(uid)) {
            throw new RuntimeException("用户的uid不能为空");
        }
        return String.valueOf(Long.valueOf(uid) & uid0X);
    }

    @Builder
    @Data
    private static class UserIdVO {

        private long userId;

        private int accountType;

        private int busType;

        private long busId;

    }
}
