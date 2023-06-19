package com.turing.wallet.utils;

public class LanguageHelper {

    public static String getValue(String plang, String str) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) {
            if (str.equals("手机号不正确")) {
                return "전화 번호가 잘못되었습니다.";
            } else if (str.equals("上传失败")) {
                return "업로드하지 못했습니다.";
            } else if (str.equals("账号已被使用")) {
                return "계정이 사용되었습니다.";
            } else if (str.equals("账号可以使用")) {
                return "계정을 사용할 수 있습니다.";
            } else if (str.equals("系统错误")) {
                return "시스템 오류";
            } else if (str.equals("账号不存在")) {
                return "계정이 존재하지 않습니다.";
            } else if (str.equals("账号异常")) {
                return "계정 예외";
            } else if (str.equals("信息填写不完全")) {
                return "불완전한 정보";
            } else if (str.equals("验证码已失效")) {
                return "인증 코드가 만료되었습니다.";
            } else if (str.equals("手机号不匹配")) {
                return "전화 번호가 일치하지 않습니다.";
            } else if (str.equals("验证码不正确")) {
                return "인증 코드가 잘못되었습니다.";
            } else if (str.equals("验证码超时")) {
                return "인증 코드 시간 초과";
            } else if (str.equals("用户名已存在")) {
                return "사용자 이름이 이미 있습니다.";
            } else if (str.equals("手机号已被注册")) {
                return "전화 번호가 등록되었습니다";
            } else if (str.equals("系统错误")) {
                return "시스템 오류";
            } else if (str.equals("注册成功")) {
                return "성공적인 등록";
            } else if (str.equals("修改密码成功")) {
                return "암호를 성공적으로 변경하십시오";
            } else if (str.equals("旧密码错误")) {
                return "이전 암호 오류";
            } else if (str.equals("用户不存在,请注册")) {
                return "사용자가 존재하지 않습니다. 등록하십시오.";
            } else if (str.equals("新密码请不要与原密码相同")) {
                return "동일한 새 암호를 사용하지 마십시오.";
            } else if (str.equals("修改密码成功")) {
                return "암호를 성공적으로 변경하십시오";
            } else if (str.equals("验证码失效")) {
                return "인증 코드 무효화";
            } else if (str.equals("验证码错误")) {
                return "인증 코드 오류";
            } else if (str.equals("输入密码有误")) {
                return "잘못된 암호";
            } else if (str.equals("验证码失效")) {
                return "인증 코드 무효화";
            } else if (str.equals("验证码正确")) {
                return "확인 코드가 맞습니다.";
            } else if (str.equals("暂不支持此币种")) {
                return "현재이 통화는 지원되지 않습니다.";
            } else if (str.equals("获取充币地址失败")) {
                return "충전 주소를 가져 오지 못했습니다.";
            } else if (str.equals("暂不支持此币种")) {
                return "현재이 통화는 지원되지 않습니다.";
            } else if (str.equals("没有查询到账户信息")) {
                return "계정 정보가 없습니다";
            } else if (str.equals("添加币种账户失败")) {
                return "통화 계정을 추가하지 못했습니다.";
            } else if (str.equals("划转失败")) {
                return "전송 실패";
            } else if (str.equals("账户异常")) {
                return "계정 예외";
            } else if (str.equals("钱包可用余额小于可划转金额")) {
                return "지갑의 사용 가능한 잔액이 양도 가능 금액보다 적습니다.";
            } else if (str.equals("划转失败：法币账户不存在")) {
                return "전송 실패 : 프랑스 통화 계좌가 존재하지 않습니다.";
            } else if (str.equals("划转失败")) {
                return "전송 실패";
            } else if (str.equals("划转成功")) {
                return "성공적인 전송";
            } else if (str.equals("账户异常，请联系客服")) {
                return "계정이 비정상 인 경우 고객 서비스에 문의하십시오.";
            } else if (str.equals("划转失败,钱包可用余额不足")) {
                return "양도하지 못했습니다. 사용 가능한 지갑이 충분하지 않습니다.";
            } else if (str.equals("理财账户可用余额小于可划转金额")) {
                return "자산 관리 계정의 잔액이 양도 가능 금액보다 적습니다.";
            } else if (str.equals("法币账户可用余额小于可划转金额")) {
                return "법정 통화 계좌 잔액이 양도 가능 금액보다 적습니다.";
            } else if (str.equals("没有记录")) {
                return "기록 없음";
            } else if (str.equals("输入数量有误")) {
                return "잘못된 입력 수";
            } else if (str.equals("账号异常，无法取现，请联系客服！")) {
                return "계좌 번호가 비정상적이거나 현금으로 바꿀 수 없으므로 고객 서비스에 문의하십시오!";
            } else if (str.equals("失败")) {
                return "실패";
            } else if (str.equals("成功")) {
                return "성공";
            } else if (str.equals("余额不足")) {
                return "불충분 한 균형";
            } else if (str.equals("正在审核，请耐心等待")) {
                return "검토 중이므로 잠시 기다려주십시오.";
            } else if (str.equals("转出失败，转出需一定手续费，账户余额不足！")) {
                return "양도하지 못했습니다. 특정 금액을 이체해야합니다. 계좌 잔액이 부족합니다.";
            } else if (str.equals("暂不支持BIOT提现")) {
                return "BIOT 철수를 지원하지 않습니다.";
            } else if (str.equals("登录失效，请重新登录")) {
                return "로그인이 잘못되었습니다. 다시 로그인하십시오.";
            } else if (str.equals("请填写钱包")) {
                return "지갑을 채우세요.";
            } else if (str.equals("请填写数量")) {
                return "수량을 기입하십시오.";
            } else if (str.equals("请选择币种")) {
                return "통화를 선택하십시오.";
            } else if (str.equals("暂不支持BIOT划转")) {
                return "BIOT 전송을 지원하지 않습니다.";
            } else if (str.equals("数量不正确")) {
                return "잘못된 수량";
            } else if (str.equals("暂不支持BIOT充值")) {
                return "BIOT 재충전을 지원하지 않습니다.";
            } else if (str.equals("获取失败")) {
                return "획득 실패";
            } else if (str.equals("没有该用户")) {
                return "그런 사용자가 없습니다.";
            } else if (str.equals("交易需通过一级身份认证")) {
                return "거래에는 1 차 인증이 필요합니다.";
            } else if (str.equals("交易需通过身份认证")) {
                return "거래를 인증해야합니다.";
            } else if (str.equals("交易需通过二级身份认证")) {
                return "거래에는 2 차 인증이 필요합니다.";
            } else if (str.equals("发送验证码失败")) {
                return "인증 코드 전송에 실패했습니다.";
            } else if (str.equals("未认证")) {
                return "인증되지 않음";
            } else if (str.equals("请先提交初级认证资料")) {
                return "먼저 기본 인증 정보를 제출하십시오.";
            } else if (str.equals("未通过审核")) {
                return "리뷰 실패";
            } else if (str.equals("请提交高级认证资料")) {
                return "고급 인증 정보를 제출하십시오.";
            } else if (str.equals("请提交认证资料")) {
                return "인증 정보를 제출하십시오.";
            } else if (str.equals("待审核")) {
                return "검토 대기 중";
            } else if (str.equals("请先完成初级认证")) {
                return "먼저 기본 인증을 완료하십시오.";
            } else if (str.equals("已认证")) {
                return "공인";
            } else if (str.equals("未查询到信息")) {
                return "정보가 없습니다";
            } else if (str.equals("获取分享链接失败,参数错误")) {
                return "공유 링크를 가져 오는 데 실패했습니다. 매개 변수 오류";
            } else if (str.equals("获取分享链接失败")) {
                return "공유 링크를 가져 오는 데 실패했습니다.";
            } else if (str.equals("注册失败")) {
                return "등록 실패";
            } else if (str.equals("用户名不能为空")) {
                return "사용자 이름은 비워 둘 수 없습니다.";
            } else if (str.equals("手机号不能为空")) {
                return "전화 번호는 비워 둘 수 없습니다.";
            } else if (str.equals("验证码不能为空")) {
                return "인증 코드는 비워 둘 수 없습니다.";
            } else if (str.equals("注册失败,验证码已失效")) {
                return "등록에 실패했습니다. 인증 코드가 만료되었습니다.";
            } else if (str.equals("注册失败,手机号不匹配")) {
                return "등록에 실패했습니다. 전화 번호가 일치하지 않습니다.";
            } else if (str.equals("注册失败,验证码不正确")) {
                return "등록에 실패했습니다. 인증 코드가 잘못되었습니다.";
            } else if (str.equals("注册失败,用户名已存在")) {
                return "등록에 실패했습니다. 사용자 이름이 이미 있습니다.";
            } else if (str.equals("注册失败,手机号已被注册")) {
                return "등록에 실패했습니다. 휴대폰 번호가 등록되었습니다.";
            } else if (str.equals("注册失败,系统错误")) {
                return "등록 실패, 시스템 오류";
            } else if (str.equals("推荐人账户异常，请下载app注册")) {
                return "리퍼러 계정이 비정상 인 경우 설치 패키지 등록을 다운로드하십시오.";
            }
        }
        return str;
    }

    public static String getShareTitle(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU))
            return "다중 체인 및 다중 통화, 원 스톱 관리, 개인 키 자체 유지, 안전 및 걱정없는 사용, 사용하기 쉬운 다중 체인 지갑, 토큰 교환, 안전하고 신속한.";
        return "多链多币种，一站式管理；私钥自持，安全无忧;多链钱包，轻松使用;代币兑换，安全快速;";
    }

    //通用
    public static String getHasCertification(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "실명 인증.";
        return "已实名认证";
    }

    public static String getLoginOutTime(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "로그인이 만료되었습니다.";
        return "登录过期";
    }

    public static String getNoLogin(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "로그인하지 않았습니다.";
        return "没有登录";
    }

    public static String getNoCertification(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "인증 없음.";
        return "没有认证";
    }

    public static String getNoAccount(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "계정이 존재하지 않습니다.";
        return "账号不存在";
    }

    public static String getAccountFrost(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "계정이 정지되었습니다.";
        return "账号已被冻结";
    }

    public static String getSystemError(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "시스템 오류";
        return "系统错误";
    }

    //认证
    public static String get1(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "ID 카드가 인증되었습니다.";
        return "身份证已被认证";
    }

    public static String get2(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "인증에 실패했습니다.";
        return "认证失败";
    }

    public static String get3(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "성공적인 인증";
        return "认证成功";
    }

    //登录
    public static String getLoginPasswordError(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "잘못된 계정 또는 비밀번호";
        return "账号或密码错误";
    }

    public static String get6(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "전화 번호가 잘못되었습니다.";
        return "手机号不正确";
    }

    public static String get7(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "전화 번호가 등록되었습니다.";
        return "手机号已被注册";
    }

    //理财
    public static String getNoData(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "데이터 없음";
        return "没有数据";
    }

    public static String getBuySuccess(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "구매 실패";
        return "购买成功";
    }

    public static String getParameterError(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "매개 변수 오류";
        return "参数错误";
    }

    public static String getAmountError(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "잘못된 수량";
        return "数量不正确";
    }

    public static String getBuyErrorNoLogin(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "구매에 실패했습니다. 먼저 로그인하십시오.";
        return "购买失败,请先登录";
    }

    public static String getBuyErrorNotSurport(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "구매 실패, 일시적 지원 안됨";
        return "购买失败,暂不支持";
    }

    public static String getBuyError(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "구매 실패";
        return "购买失败";
    }

    public static String getBuyErrorAmountTooLow(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "시작 금액보다 작을 수 없습니다.";
        return "不能小于起投金额";
    }

    public static String getBuyErrorAccountForst(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "구매 실패, 계정 정지.";
        return "购买失败,账号被冻结";
    }

    public static String getBuyErrorAccountError(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "구매 실패, 계정 이상.";
        return "购买失败,账号异常";
    }

    public static String getBuyErrorProductTooLow(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "제품 구매 금액 부족";
        return "产品可购买额度不足";
    }

    public static String getBuyErrorBalanceTooLow(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "구매 실패, 잔액 부족";
        return "购买失败,余额不足";
    }

    public static String getBuyErrorNoRenzheng(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "구매가 실패하면 먼저 실명 인증을 완료하십시오.";
        return "购买失败,请先完成实名认证";
    }

    public static String getBuyErrorProductInfo(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "구매 실패, 제품 정보 수신 실패.";
        return "购买失败，获取产品信息失败";
    }

    public static String getBuyErrorProductNotExits(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "제품이 존재하지 않습니다.";
        return "产品不存在";
    }

    public static String getBuyErroVersionLow(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "구매하지 못했습니다. 버전이 너무 낮습니다.";
        return "购买失败，版本过低";
    }

    //公告
    public static String getNoticeNoData(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "제품이 존재하지 않습니다.";
        return "产品不存在";
    }

    //升级
    public static String getVersionError(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "새 버전을 가져 오는 중 오류가 발생했습니다.";
        return "获取新版本出错";
    }

    public static String getVersionTipNoVersion(String plang) {
        if (plang != null && plang.equals(Constants.LANGUAGE_HANYU)) return "새 버전 없음.";
        return "没有新版本";
    }
}
