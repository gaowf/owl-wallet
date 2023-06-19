package com.turing.wallet.enums;


import lombok.Getter;

/**
 * 登录类型
 */
public enum LoginTypeEnum {

    PHONE(1, "手机号登录"),
    EMAIL(2, "邮件登录"),
    ;
    @Getter
    private Integer code;

    private String desc;

    LoginTypeEnum(Integer code,
                  String desc) {
        this.code = code;
        this.desc = desc;
    }
}
