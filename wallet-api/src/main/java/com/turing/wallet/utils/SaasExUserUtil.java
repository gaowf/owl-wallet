package com.turing.wallet.utils;

import javax.crypto.Mac;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Base64;
import java.util.concurrent.ThreadLocalRandom;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;

@Slf4j
public class SaasExUserUtil {

    public static final String PBKDF2_ALGORITHM = "PBKDF2WithHmacSHA1";

    //生成密文的长度
    public static final int HASH_SIZE = 128;

    // 迭代次数
    public static final int PBKDF2_ITERATIONS = 1000;


    /**
     * 生成随机密钥
     *
     * @param userId
     * @param passwordType
     * @return
     */
    public static String genSalt(int userId, String passwordType) {
        return hmacSha256Signature(genSimpleUid() + userId + passwordType,
                String.valueOf(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli()));
    }

    /**
     * 生成加密密码
     *
     * @param password
     * @param salt
     * @return
     */
    public static String genNewPassword(String password, String salt) {
        return hmacSha256Signature(password, salt);
    }


    /**
     * @param pwd          用户输入密码
     * @param loginPwd     用户密码
     * @param loginPwdSalt 用户密码盐值
     * @return true 验证通过  false 验证失败
     */
    public static boolean authUserLoginPassword(String pwd, String loginPwd, String loginPwdSalt) {
        String encryptPwd = hmacSha256Signature(pwd, loginPwdSalt);
        if (!encryptPwd.equals(loginPwd)) {
            return false;
        }
        return true;
    }


    /**
     * 加密
     *
     * @param message 待加密连数据
     * @param secret  盐值
     * @return
     */
    public static String hmacSha256Signature(String message, String secret) {
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] hashs = sha256_HMAC.doFinal(message.getBytes());
            return byteArrayToHexString(hashs);
            //return signToBase64(hashs);
        } catch (Exception e) {
            log.error("e:{}", ExceptionUtils.getStackTrace(e));
        }
        return null;
    }

    /**
     * 加密结果转换为base64
     *
     * @param hashs
     * @return
     */
    private static String signToBase64(byte[] hashs) {
        return Base64.getEncoder().encodeToString(hashs);
    }

    /**
     * 加密结果转换为16进制
     *
     * @param hashs
     * @return
     */
    private static String signToHex(byte[] hashs) {
        StringBuilder sb = new StringBuilder();
        for (byte x : hashs) {
            String b = Integer.toHexString(x & 0XFF);
            if (b.length() == 1) {
                b = '0' + b;
            }
            sb.append(b);
        }
        return sb.toString();
    }

    private static String byteArrayToHexString(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b != null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1) {
                hs.append('0');
            }
            hs.append(stmp);
        }
        return hs.toString();
    }


    /**
     * 生成用户随机uid
     *
     * @return
     */
    private static String genSimpleUid() {
        return ThreadLocalRandom.current().ints(100000000, Integer.MAX_VALUE).toString();
    }

    /**
     * 生成用户随机uid
     *
     * @return
     */
    private static String formatInt(Long a) {
        return ThreadLocalRandom.current().ints(100000000, Integer.MAX_VALUE).toString();
    }


    /**
     * 根据password和salt生成密文
     */
    public static String getPBKDF2(String password, String salt) throws NoSuchAlgorithmException,
            InvalidKeySpecException {
        //将16进制字符串形式的salt转换成byte数组
        byte[] bytes = DatatypeConverter.parseHexBinary(salt);
        KeySpec spec = new PBEKeySpec(password.toCharArray(), bytes, PBKDF2_ITERATIONS, HASH_SIZE * 4);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(PBKDF2_ALGORITHM);
        byte[] hash = secretKeyFactory.generateSecret(spec).getEncoded();
        //将byte数组转换为16进制的字符串
        return DatatypeConverter.printHexBinary(hash);
    }

    /**
     * 对输入的密码进行验证
     *
     * @return:
     * @Date: 2020-05-18
     */
    public static boolean verify(String password, String salt, String key)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        // 用相同的盐值对用户输入的密码进行加密
        String result = getPBKDF2(password, salt);
        // 把加密后的密文和原密文进行比较，相同则验证成功，否则失败
        return result.equals(key);
    }

}
