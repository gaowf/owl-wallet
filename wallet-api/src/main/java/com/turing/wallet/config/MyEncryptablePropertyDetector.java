package com.turing.wallet.config;

import com.ulisesbocchio.jasyptspringboot.EncryptablePropertyDetector;

/**
 * 从其他系统复制来的兼容代码，做数据库密码加解密
 */
public class MyEncryptablePropertyDetector implements EncryptablePropertyDetector {

    /**
     * 自定义的加入值
     */
    public static final String ENCODED_PASSWORD_HINT = "wbf_";

    @Override
    public boolean isEncrypted(String s) {
        if (null != s) {
            return s.startsWith(ENCODED_PASSWORD_HINT);
        }
        return false;
    }

    @Override
    public String unwrapEncryptedValue(String s) {
        return s.substring(ENCODED_PASSWORD_HINT.length());
    }
}
