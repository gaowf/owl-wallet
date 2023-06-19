package com.turing.wallet.enums;

import lombok.Getter;

public enum SliderStatusEnum {

    CLOSE(0,"close"),
    /**
     * 全开
     */
    OPEN(1, "open"),
    /**
     * 只开启安卓
     */
    OPEN_WEB(2, "open_web"),

    ;

    @Getter
    private Integer status;
    private String desc;

    SliderStatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }
}
