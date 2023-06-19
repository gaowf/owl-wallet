package com.turing.wallet.enums;

/**
 * 查询限制.
 */
public enum QueryLimit {
    FIND_PASSWORD(1, 10, 300, BoolStatus.ENABLE.getValue(), "找回密码"),
    EMAIL_REGISTER(2, 10, 300, BoolStatus.ENABLE.getValue(), "邮件注册"),
    MOBILE_REGISTER(3, 10, 300, BoolStatus.ENABLE.getValue(), "手机注册");

    private int scenes;
    private int limit;
    private int timeout;
    private byte status;
    private String text;

    QueryLimit(int scenes, int limit, int timeout, byte status, String text) {
        this.scenes = scenes;
        this.limit = limit;
        this.timeout = timeout;
        this.status = status;
        this.text = text;
    }

    public int getScenes() {
        return scenes;
    }

    public void setScenes(int scenes) {
        this.scenes = scenes;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
