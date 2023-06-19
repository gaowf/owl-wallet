package com.turing.wallet.enums;

/**
 * @Auther: L.C
 * @Date: 2020-05-21 11:01
 */

public enum AuthLevel {
    NONE((byte) 0, "未认证"),
    AUTH_SIMPLE((byte) 1, "实名认证"),
    AUTH_PIC((byte) 2, "图片认证"),
    AUTH_VIO((byte) 3, "视频认证");

    public byte value;
    public String description;

    AuthLevel(byte value, String description) {
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
