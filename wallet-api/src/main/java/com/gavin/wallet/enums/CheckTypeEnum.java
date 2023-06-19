package com.turing.wallet.enums;


import lombok.Getter;

/**
 * 登录校验类型
 */
public enum CheckTypeEnum {

    GOOGLE("1","谷歌验证"),
    PHONE("2", "手机号验证"),
    EMAIL("3", "邮件验证"),
    ;
    @Getter
    private String code;

    private String desc;

    CheckTypeEnum(String code,
                  String desc) {
        this.code = code;
        this.desc = desc;
    }
}
