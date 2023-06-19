package com.turing.wallet.utils;

import org.springframework.util.StringUtils;

/**
 * 脱敏 复制 大冲子
 */
public final class InfoDesensitizationUtil {
    private InfoDesensitizationUtil() {
        //
    }

    /**
     * 手机脱敏.
     *
     * @param mobile 手机号
     * @return
     */
    public static String desensitizationMobile(String mobile) {
        if (StringUtils.isEmpty(mobile)) {
            return mobile;
        }
        int len = mobile.length();
        if (len >= 11) {
            mobile = mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        } else if (len >= 7) {
            mobile = mobile.substring(0, 3) + "****" + mobile.substring(len - 2, len);
        } else {
            return mobile;
        }
        return mobile;
    }


    /**
     * 邮箱脱敏.
     *
     * @param email 邮箱.
     * @return
     */
    public static String desensitizationEmail(String email) {
        if (StringUtils.isEmpty(email)) {
            return email;
        }
        return email.replaceAll("(^\\w{2})[^@]*(@.*$)", "$1****$2");
    }

    /**
     * 姓名脱敏
     *
     * @return:
     * @Date: 2020-08-26
     */
    public static String desensitizationName(String name) {

        String newName = "";
        if (name == null || name.isEmpty()) {
            return newName;
        }
        int nameLen = name.length();
        if (name.length() <= 2) {
            newName = "* " + name.substring(nameLen - 1, nameLen);
        }
        if (name.length() >= 3) {
            newName = name.substring(0, 1) + " * " + name.substring(nameLen - 1, nameLen);
        }

        return newName;
    }


    /**
     * 身份证脱敏
     *
     * @return:
     * @Date: 2020-08-26
     */
    public static String desensitizationCard(String cardNum) {
        if (org.apache.commons.lang3.StringUtils.isBlank(cardNum)) {
            return "";
        }
        return cardNum.replaceAll("(?<=\\w{3})\\w(?=\\w{3})", "*");
    }

    /**
     * 护照脱敏
     *
     * @return:
     * @Date: 2020-08-26
     */
    public static String desensitizationPassport(String cardNum) {
        String newCardNum = "";
        if (org.apache.commons.lang3.StringUtils.isBlank(cardNum)) {
            return newCardNum;
        }
        int len = cardNum.length();
        if (len >= 3 && len <= 6) {
            newCardNum = "***" + cardNum.substring(len - 3, len);
        } else if (len > 6) {
            newCardNum = cardNum.substring(0, 3) + new String(new char[cardNum.length() - 5]).replace("\0", "*") + cardNum.substring(cardNum.length() - 3);
        } else {
            newCardNum = cardNum;
        }
        return newCardNum;
    }


}
