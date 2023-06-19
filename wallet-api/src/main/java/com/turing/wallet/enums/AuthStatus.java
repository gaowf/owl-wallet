package com.turing.wallet.enums;


public enum AuthStatus {
    NON((byte) 0, "未审核"),
    ACCEPT((byte) 1, "通过"),
    FAIL((byte) 2, "未通过"),
    LOSE((byte) 3, "认证失败");

    public byte value;
    public String description;

    AuthStatus(byte value, String description) {
        this.value = value;
        this.description = description;
    }

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
