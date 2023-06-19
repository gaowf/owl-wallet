package com.turing.wallet.enums;


import lombok.Getter;

/**
 * 客户端类型
 */
public enum ClientTypeEnum {

    ANDROID("Android",1),
    IOS("iOS",2),
    PC("PC", 3),
    ;


    @Getter
    private String code;
    @Getter
    private Integer value;

    ClientTypeEnum(String code,
                   Integer value) {
        this.code = code;
        this.value = value;
    }
}
