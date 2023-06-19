package com.turing.wallet.enums;


import lombok.Getter;

public enum OfficialTypeEnum {

    EMAIL(1, "邮箱"),
    TELEGRAM(2, "Telegram"),
    LINKEDLN(3, "Linkedln"),
    ;
    @Getter
    private final Integer code;

    private final String desc;

    OfficialTypeEnum(Integer code,
                     String desc) {
        this.code = code;
        this.desc = desc;
    }
}
