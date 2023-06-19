package com.turing.wallet.enums;

import lombok.Getter;

public enum OfficialCommunityEnum {


    COMMUNITY(1, "社群"),
    DOMAIN_NAME(2, "域名"),
    ;
    @Getter
    private final Integer code;

    private final String desc;

    OfficialCommunityEnum(Integer code,
                     String desc) {
        this.code = code;
        this.desc = desc;
    }
}
