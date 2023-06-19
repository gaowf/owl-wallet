package com.turing.wallet.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StateEnum {

    DELETE(0, "删除"),
    OPEN(1, "上线"),
    CLOSE(2, "下线");

    int code;
    String desc;

    public static boolean isOpen(int code) {
        return code == StateEnum.OPEN.getCode();
    }

}
