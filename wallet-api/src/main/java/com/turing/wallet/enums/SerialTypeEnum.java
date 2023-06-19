package com.turing.wallet.enums;

import lombok.Getter;

public enum SerialTypeEnum {

    ALI(1, "ali"),

    HCAPTCHA(2, "hcaptcha"),

    ;

    @Getter
    private Integer code;
    private String desc;

    SerialTypeEnum(Integer status, String desc) {
        this.code = status;
        this.desc = desc;
    }
}
