package com.turing.wallet.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VisibleStateEnum {

    OPEN((byte) 1, "可见"),
    CLOSE((byte) 2, "隐藏");

    Byte code;
    String desc;

    public static boolean isOpen(Byte code) {
        return code == VisibleStateEnum.OPEN.getCode();
    }

}
