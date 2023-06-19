package com.turing.wallet.utils;

public class LanguageHelperEnglish {

    public static String getValue(String plang, String str) {
        if (plang != null && str.equals(Constants.LANGUAGE_ENGLISH)) {
            if (plang.equals("手机号不正确")) {
                return "phone number incorrect";
            } else if (plang.equals("上传失败")) {
                return "upload failed";
            } else if (plang.equals("账号已被使用")) {
                return "account is already in use";
            } else if (plang.equals("账号可以使用")) {
                return "account can be used";
            } else if (plang.equals("系统错误")) {
                return "system error";
            } else if (plang.equals("账号不存在")) {
                return "the account does not exist";
            } else if (plang.equals("账号异常")) {
                return "account abnormal";
            } else if (plang.equals("信息填写不完全")) {
                return "information incomplete";
            } else if (plang.equals("验证码已失效")) {
                return "verification code invalid";
            } else if (plang.equals("手机号不匹配")) {
                return "Phone numbers don't match";
            } else if (plang.equals("验证码不正确")) {
                return "verification code incorrect";
            } else if (plang.equals("验证码超时")) {
                return "verification code timeout";
            } else if (plang.equals("用户名已存在")) {
                return "The user name already exists.";
            } else if (plang.equals("手机号已被注册")) {
                return "The phone number has been registered.";
            } else if (plang.equals("系统错误")) {
                return "System error";
            } else if (plang.equals("注册成功")) {
                return "register success";
            } else if (plang.equals("修改密码成功")) {
                return "new password success";
            } else if (plang.equals("旧密码错误")) {
                return "old password error";
            } else if (plang.equals("用户不存在,请注册")) {
                return "User not exist. Please register.";
            } else if (plang.equals("新密码请不要与原密码相同")) {
                return "The new password should not be the same as the old one.";
            } else if (plang.equals("修改密码成功")) {
                return "new password success";
            } else if (plang.equals("验证码失效")) {
                return "verification code invalid";
            } else if (plang.equals("验证码错误")) {
                return "verification code error";
            } else if (plang.equals("输入密码有误")) {
                return "password incorrect";
            } else if (plang.equals("验证码失效")) {
                return "verification code invalid";
            } else if (plang.equals("验证码正确")) {
                return "verification code correct";
            } else if (plang.equals("暂不支持此币种")) {
                return "This currency is not supported.";
            } else if (plang.equals("获取充币地址失败")) {
                return "failed to get the charging address";
            } else if (plang.equals("暂不支持此币种")) {
                return "The currency is not supported.";
            } else if (plang.equals("没有查询到账户信息")) {
                return "failed to check account information";
            } else if (plang.equals("添加币种账户失败")) {
                return "failed to add currency account";
            } else if (plang.equals("划转失败")) {
                return "Transfer failed";
            } else if (plang.equals("账户异常")) {
                return "account abnormal";
            } else if (plang.equals("钱包可用余额小于可划转金额")) {
                return "The available balance of the wallet is less than the transferable amount";
            } else if (plang.equals("划转失败：法币账户不存在")) {
                return "Transfer failed: fiat money account does not exist";
            } else if (plang.equals("划转失败")) {
                return "Transfer failed";
            } else if (plang.equals("划转成功")) {
                return "transfer success";
            } else if (plang.equals("账户异常，请联系客服")) {
                return "account abnormal, please contact customer service.";
            } else if (plang.equals("划转失败,钱包可用余额不足")) {
                return "Transfer failed, wallet available balance insufficient.";
            } else if (plang.equals("理财账户可用余额小于可划转金额")) {
                return "The available balance of a wealth management account is less than the transferable amount.";
            } else if (plang.equals("法币账户可用余额小于可划转金额")) {
                return "The available balance of legal tender account is less than the transferable amount.";
            } else if (plang.equals("没有记录")) {
                return "no record";
            } else if (plang.equals("输入数量有误")) {
                return "input quantity error";
            } else if (plang.equals("账号异常，无法取现，请联系客服！")) {
                return "Account abnormal, withdrawn failed. Please contact customer service!";
            } else if (plang.equals("失败")) {
                return "failure";
            } else if (plang.equals("成功")) {
                return "Success";
            } else if (plang.equals("余额不足")) {
                return "balance insufficient";
            } else if (plang.equals("正在审核，请耐心等待")) {
                return "Under review, please be patient.";
            } else if (plang.equals("转出失败，转出需一定手续费，账户余额不足！")) {
                return "Account balance insufficient! Turn out failure, needing service charge.";
            } else if (plang.equals("暂不支持BIOT提现")) {
                return "BIOT 철수를 지원하지 않습니다.";
            } else if (plang.equals("登录失效，请重新登录")) {
                return "Logon expiration, Please re-login.";
            } else if (plang.equals("请填写钱包")) {
                return "Please fill out the chosen wallet.";
            } else if (plang.equals("请填写数量")) {
                return "please fill in the required quantity.";
            } else if (plang.equals("请选择币种")) {
                return "Please Choose Currency.";
            } else if (plang.equals("暂不支持BIOT划转")) {
                return "BIOT 전송을 지원하지 않습니다.";
            } else if (plang.equals("数量不正确")) {
                return "quantity incorrect";
            } else if (plang.equals("暂不支持BIOT充值")) {
                return "BIOT 재충전을 지원하지 않습니다.";
            } else if (plang.equals("获取失败")) {
                return "Not logged in";
            } else if (plang.equals("没有该用户")) {
                return "The user does not exist";
            } else if (plang.equals("交易需通过一级身份认证")) {
                return "Transaction requires primary authentication.";
            } else if (plang.equals("交易需通过身份认证")) {
                return "거래를 인증해야합니다.";
            } else if (plang.equals("交易需通过二级身份认证")) {
                return "Transaction requires secondary identification.";
            } else if (plang.equals("发送验证码失败")) {
                return "Failed to send verification code";
            } else if (plang.equals("未认证")) {
                return "unauthorized";
            } else if (plang.equals("请先提交初级认证资料")) {
                return "Please submit primary certification materials first.";
            } else if (plang.equals("未通过审核")) {
                return "Not approved";
            } else if (plang.equals("请提交高级认证资料")) {
                return "Please submit advanced certification information.";
            } else if (plang.equals("请提交认证资料")) {
                return "Please submit the certification information";
            } else if (plang.equals("待审核")) {
                return "To be audited";
            } else if (plang.equals("请先完成初级认证")) {
                return "Please complete the primary certification first.";
            } else if (plang.equals("已认证")) {
                return "certified";
            } else if (plang.equals("未查询到信息")) {
                return "No information was found";
            } else if (plang.equals("获取分享链接失败,参数错误")) {
                return "parameter error, failed to get share link";
            } else if (plang.equals("获取分享链接失败")) {
                return "failed to get share link";
            } else if (plang.equals("注册失败")) {
                return "Registration failed";
            } else if (plang.equals("用户名不能为空")) {
                return "User name cannot be empty.";
            } else if (plang.equals("手机号不能为空")) {
                return "Cell phone number cannot be empty.";
            } else if (plang.equals("验证码不能为空")) {
                return "Verification code cannot be empty.";
            } else if (plang.equals("注册失败,验证码已失效")) {
                return "Registration failed, verification code expired.";
            } else if (plang.equals("注册失败,手机号不匹配")) {
                return "Registration failed, mobile phone number does not match.";
            } else if (plang.equals("注册失败,验证码不正确")) {
                return "Registration failed, verification code is incorrect.";
            } else if (plang.equals("注册失败,用户名已存在")) {
                return "Registration failed, user name already exists.";
            } else if (plang.equals("注册失败,手机号已被注册")) {
                return "Registration failed, the mobile phone number has been registered.";
            } else if (plang.equals("注册失败,系统错误")) {
                return "Registration failed, system error.";
            } else if (plang.equals("推荐人账户异常，请下载app注册")) {
                return "Referrer account is abnormal, please download app for registration.";
            }
        }
        return plang;
    }

    public static String getShareTitle(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU))
            return "Multi-chain multi-currency, one-stop management;Private key self-held, safe and secure;Multi-chain wallet, easy to use;Token exchange, safe and fast";
        return "多链多币种，一站式管理；私钥自持，安全无忧;多链钱包，轻松使用;代币兑换，安全快速;";
    }

    //通用
    public static String getHasCertification(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "Verified by real name";
        return "已实名认证";
    }

    public static String getLoginOutTime(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "login expiration";
        return "登录过期";
    }

    public static String getNoLogin(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "Not logged in";
        return "没有登录";
    }

    public static String getNoCertification(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "No certification";
        return "没有认证";
    }

    public static String getNoAccount(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "The account does not exist.";
        return "账号不存在";
    }

    public static String getAccountFrost(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU))
            return "account frozen";
        return "账号已被冻结";
    }

    public static String getSystemError(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "system error";
        return "系统错误";
    }

    //认证
    public static String get1(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "The ID card has been authenticated.";
        return "身份证已被认证";
    }

    public static String get2(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "Authentication failed";
        return "认证失败";
    }

    public static String get3(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU))
            return "Authentication Ok / Authentication success";
        return "认证成功";
    }

    //登录
    public static String getLoginPasswordError(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "account or password incorrect";
        return "账号或密码错误";
    }

    public static String get6(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "phone number incorrect";
        return "手机号不正确";
    }

    public static String get7(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "The phone number has been registered.";
        return "手机号已被注册";
    }

    //理财
    public static String getNoData(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "no data";
        return "没有数据";
    }

    public static String getBuySuccess(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "purchase success";
        return "购买成功";
    }

    public static String getParameterError(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "parameter error";
        return "参数错误";
    }

    public static String getAmountError(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "number incorrect";
        return "数量不正确";
    }

    public static String getBuyErrorNoLogin(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "Purchase failed, please login first";
        return "购买失败,请先登录";
    }

    public static String getBuyErrorNotSurport(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU))
            return "Purchase failed, temporarily not supported.";
        return "购买失败,暂不支持";
    }

    public static String getBuyError(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "Purchase failed";
        return "购买失败";
    }

    public static String getBuyErrorAmountTooLow(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "Not less than the minimum amount.";
        return "不能小于起投金额";
    }

    public static String getBuyErrorAccountForst(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "account frozen, purchase failed.";
        return "购买失败,账号被冻结";
    }

    public static String getBuyErrorAccountError(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "account abnormal, purchase failed.";
        return "购买失败,账号异常";
    }

    public static String getBuyErrorProductTooLow(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU))
            return "The amount of products available for purchase is insufficient.";
        return "产品可购买额度不足";
    }

    public static String getBuyErrorBalanceTooLow(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "insufficient balance, purchase failed.";
        return "购买失败,余额不足";
    }

    public static String getBuyErrorNoRenzheng(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU))
            return "Purchase failed; please complete the real-name authentication first.";
        return "购买失败,请先完成实名认证";
    }

    public static String getBuyErrorProductInfo(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU))
            return "failed to obtain product information, purchase failed.";
        return "购买失败，获取产品信息失败";
    }

    public static String getBuyErrorProductNotExits(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "Product does not exist.";
        return "产品不存在";
    }

    public static String getBuyErroVersionLow(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "low server version, purchase failed.";
        return "购买失败，版本过低";
    }

    //公告
    public static String getNoticeNoData(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "Product does not exist";
        return "产品不存在";
    }

    //升级
    public static String getVersionError(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "Error in retrieving new version";
        return "获取新版本出错";
    }

    public static String getVersionTipNoVersion(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "No new version";
        return "没有新版本";
    }

}
