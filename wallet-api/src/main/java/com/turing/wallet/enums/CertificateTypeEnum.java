package com.turing.wallet.enums;


import lombok.Getter;

/**
 * 登录校验类型
 */
public enum CertificateTypeEnum {

    ID("1","身份证"),
    PASSPORT("2", "护照"),
    ;
    @Getter
    private String code;

    private String desc;

    CertificateTypeEnum(String code,
                        String desc) {
        this.code = code;
        this.desc = desc;
    }
}
