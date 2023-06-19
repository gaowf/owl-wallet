package com.turing.wallet.enums;


import lombok.Getter;

/**
 * 账户类型
 */
public enum AccountTypeEnum {

    PARENT_ACCOUNT(1L, "母账户"),
    SUB_ACCOUNT(2L, "子账户"),
    ;
    @Getter
    private Long code;

    private String desc;

    AccountTypeEnum(Long code,
                    String desc) {
        this.code = code;
        this.desc = desc;
    }
}
