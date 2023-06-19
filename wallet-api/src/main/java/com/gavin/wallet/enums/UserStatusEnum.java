package com.turing.wallet.enums;


import lombok.Getter;

/**
 * 用户状态
 */
public enum UserStatusEnum {

    NORMAL("1", "正常"),
    FROZEN("2", "冻结"),
    EXAMINING("3", "正在审核"),
    UN_PASS("4", "审核未通过"),

    ;
    @Getter
    private String code;

    private String desc;

    UserStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
