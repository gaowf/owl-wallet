package com.turing.wallet.enums;

import lombok.Getter;

public enum SideTypeEnum {

    /**
     * 买
     */
    BUY(1, "buy"),
    /**
     * 卖
     */
    SELL(-1, "sell"),

    ;

    @Getter
    private Integer status;
    @Getter
    private String desc;

    SideTypeEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public static SideTypeEnum getEnum(String desc) {
        for (SideTypeEnum typeEnum : SideTypeEnum.values()) {
            if (typeEnum.getDesc().equals(desc)) {
                return typeEnum;
            }
        }
        return null;
    }
}
