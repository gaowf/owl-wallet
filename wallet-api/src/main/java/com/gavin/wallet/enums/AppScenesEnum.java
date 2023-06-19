package com.turing.wallet.enums;

/**
 * 场景枚举
 *
 * @Desc:
 * @Date: 2020-05-22 17:08
 */
public enum AppScenesEnum {
    RegisterByMobile("1", "手机号注册"),
    RegistByEmail("2", "邮箱注册"),
    PhoneLogin("3", "手机登陆"),
    EmailLogin("4", "邮箱登录"),
    LoginReminding("5", "登录提醒"),
    BindMobileNum("6", "绑定手机号码"),
    UpdateMobileNum("7", "修改手机号"),
    BindEmail("8", "绑定邮箱"),
    ModifyEmail("9", "修改邮箱"),
    UpdateLoginPassword("10", "修改登录密码"),
    FindPassword("11", "找回密码"),
    CloseMobileValid("12", "关闭手机验证"),
    AddBankCard("13", "添加银行卡"),
    EditBankCard("14", "修改银行卡"),
    OpenGoogleValid("15", "开启Google认证"),
    CloseMobileValidate("16", "关闭手机验证"),
    SetCapitalPassword("17", "修改资金密码"),
    CloseGoogleValidate("18", "关闭谷歌验证"),
    WithdrawApply("19", "提币申请"),


    ;


    private String code;
    private String message;

    AppScenesEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public static AppScenesEnum getAppScenesEnumByCode(String code) {
        for (AppScenesEnum appScenesEnum : AppScenesEnum.values()) {
            if (code.equals(appScenesEnum.code)) {
                return appScenesEnum;
            }
        }
        return null;
    }
}
