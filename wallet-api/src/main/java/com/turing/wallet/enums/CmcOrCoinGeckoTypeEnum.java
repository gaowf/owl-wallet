package com.turing.wallet.enums;


import lombok.Getter;

/**
 * 账户类型
 */
public enum CmcOrCoinGeckoTypeEnum {

    CMC(1L, "cms"),
    CoinGecko(2L, "coingecko");
    @Getter
    private Long code;

    private String desc;

    CmcOrCoinGeckoTypeEnum(Long code,
                           String desc) {
        this.code = code;
        this.desc = desc;
    }
}
