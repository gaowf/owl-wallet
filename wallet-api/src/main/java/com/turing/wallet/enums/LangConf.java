package com.turing.wallet.enums;

/**
 * 验证码模板
 */
public enum LangConf {
    UserMobileLoginTip(1, "userMobileLoginTip", "登录短信提醒模板"),
    SmsValidCode(2, "smsValidCode", "短信验证码模板"),
    EmailValidCode(3, "emailValidCode", "邮件验证码模板"),
    UserEmailLoginTip(4, "userEmailLoginTip", "用户邮箱登录提醒模板"),
    UserInvitionEmailLoginTip(5, "userInvitionEmailTip", "用户邀请邮箱提醒模板"),

    ExceptionHandlingRemoteLoginReminderEmail(48, "ExceptionHandlingRemoteLoginReminderEmail", "异地登录提醒"),
    ExceptionHandlingRemoteLoginReminderSms(49, "ExceptionHandlingRemoteLoginReminderSms", "异地登录提醒"),

    ApplyCurrencySendEmail(50,"applyCurrencySendEmail","新上币申请邮件提醒模板"),
    ;


    private int key;
    private String value;
    private String desc;

    LangConf(int key, String value, String desc) {
        this.key = key;
        this.value = value;
        this.desc = desc;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
