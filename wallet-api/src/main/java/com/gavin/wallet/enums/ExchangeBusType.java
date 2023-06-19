package com.turing.wallet.enums;

import lombok.Getter;

/**
 * 交易所业务类型
 */
public enum ExchangeBusType {

    DEFAULT(1L, "", "云交易所"),
    ;

    @Getter
    private Long code;

    private String type;

    private String desc;

    ExchangeBusType(Long code,
                    String type,
                    String desc) {
        this.code = code;
        this.type = type;
        this.desc = desc;
    }

}
