package com.turing.wallet.enums;

import com.turing.wallet.constants.CommonByte;
import lombok.AllArgsConstructor;

/**
 * 状态.
 */
@AllArgsConstructor
public enum BoolStatus {
    DISABLE(CommonByte._0, "禁用"),
    ENABLE(CommonByte._1, "启用");

    private byte value;
    private String text;

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
