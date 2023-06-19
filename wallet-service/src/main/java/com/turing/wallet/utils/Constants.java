package com.turing.wallet.utils;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Constants {

    public static final String LANGUAGE_HANYU = "feizhou";
    public static final String LANGUAGE_ZH = "ZH";

    public static final String LANGUAGE_ENGLISH = "English";
    // http://47.91.247.228:8111
    //    public static final boolean IS_STOP_SERVING = false;//停服"服务器正在维护，请稍等！"
    public static final String STOP_SERVING_TIP = "服务器正在维护，请稍等！";
    public static final String TIP_ERROR_UPDATE = "请在“关于我们”界面下载最新版本，或联系客服";
    //    public static final String ETH_BALANCE_PATH = "http://47.75.175.20:8545";
    public static final String ETH_BALANCE_PATH = "http://47.52.75.160:8545";
    public static final String ETH_LOCAL_PATH = "https://mainnet.infura.io/f4zMTA4eUXpnsDnnrpfM";
    //    public static final String ETH_LOCAL_PATH =
    // "https://rinkeby.infura.io/v3/eac982aa13834cca9a31620e215a571f";

    public static final String SysErrorPhone = "17603064349";

    public static final String DEFAULT_HEAD = "";

    public static final String ENTRY_TYPE_SELL = "卖出";
    public static final String ENTRY_TYPE_BUY = "买入";

    public static final String PLATFORM_ETH = "ETH";
    public static final String PLATFORM_ACC = "ACC";
    public static final String PLATFORM_USDT = "USDT";
    public static final String PLATFORM_EOS = "EOS";
    public static final String PLATFORM_BTC = "BTC";

    // 理财投资手续费
    public static final BigDecimal FM_ETH_FEE = BigDecimal.valueOf(0.01);
    public static final String FM_BIOT_NAME = "BIOT"; // BIOT价格0.12美元
    public static final BigDecimal FM_BIOT_DEFAULT_PRICE = BigDecimal.valueOf(0.12); // BIOT价格默认0.12美元

    //    public static final String ETH_LOCAL_PATH = "47.91.247.228:8111";
    //    public static final String ETH_LOCAL_PATH = "127.0.0.1:8111";
    //    public static final String ETH_MAIN_PATH = "https://mainnet.infura.io/f4zMTA4eUXpnsDnnrpfM";

    // 0x91b7afa34696df317f403dc33953c3d679c5ba12
    //    public static final String ALIYUN_OSS_PIC_PATH =
    // "https://turingcoin.oss-cn-beijing.aliyuncs.com/";
    public static final String ALIYUN_OSS_PIC_PATH = "https://saasex.oss-cn-shenzhen.aliyuncs.com/";
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    //
    //    public static final BigInteger gasPrice  = BigInteger.valueOf(5_000_000_000L);
    //    public static final BigInteger gasLimit = BigInteger.valueOf(255556);

    public static final BigInteger gasPrice = BigInteger.valueOf(30_000_000_000L);
    public static final BigInteger gasLimit = BigInteger.valueOf(180_556);

    public static final int decimals = 18; // 动态获取

    public static final String WITHDRAW_STATUS_ING = "正在审核";
    public static final String WITHDRAW_STATUS_PUTCOIN = "已放币";
    public static final String WITHDRAW_STATUS_REJECT = "已拒绝";
    public static final String WITHDRAW_STATUS_FINISH = "已完成";

    public static final String USER_STATUS_FROZEN = "冻结";
    public static final String USER_STATUS_NORMAL = "正常";
    public static final String USER_STATUS_AUDIT_FAILE = "审核未通过";
    public static final String USER_STATUS_AUDITING = "待审核";
    public static final String USER_STATUS_NO_AUDIT = "未认证";
    public static final String USER_STATUS_ERROR = "异常";
    public static final String USER_STATUS_NO_ALLOWED = "永久禁用";

    public static final String USER_STATUS_UNNORMAL_TIP_FROZEN = "您的账号有正在申诉的订单，暂时无法进行此操作！";
    public static final String USER_STATUS_UNNORMAL_TIP_FAILE = "您的账号未通过审核，无法进行此操作！";
    public static final String USER_STATUS_UNNORMAL_TIP_AUDITING = "您的账号正在审核，暂时无法进行此操作！";
    public static final String USER_STATUS_UNNORMAL_TIP_ERROR = "您的账号异常，请联系客服处理！";

    public static final String ORDER_STATUS_FROZEN = "冻结中";

    public static final String ACCESS_KEY_ID = "LTAIIJFgDg2UQcQX";
    public static final String ACCESS_KEY_SECRET = "cakL6xLF9dgIOE0sLOb4rW5JMEI3Zl";
    public static final String SIGN_NAME = "COINBAG";
    public static final String PRODUCT = "Dysmsapi"; // 短信API产品名称（短信产品名固定，无需修改）
    public static final String DOMAIN = "dysmsapi.aliyuncs.com"; // 短信API产品域名（接口地址固定，无需修改）

    public static final String PAY_ALI = "支付宝";
    public static final String PAY_BANK = "银行卡";

    public static final String ENTRY_ORDER_ENABLE = "可交易"; // 可交易
    public static final String ENTRY_ORDER_ING = "正在交易"; // 正在交易
    public static final String ENTRY_ORDER_CLOSE = "隐藏"; // 可交易数量小于最少限额，隐藏订单，但有未完成的订单，可能再打开
    public static final String ENTRY_ORDER_FINISH = "不可交易"; // 已完成

    public static final String ORDER_PAYED = "买方已支付";
    public static final String ORDER_NOT_PAY = "待支付";
    public static final String ORDER_OUTTIME_CANCLE = "超时取消";

    public static final String CONTRACT_ADDRESS_USDI =
            "0x218c74a0d2e5a5b30e2c12030dc735a49930fe20"; // 合约地址，写到数据库
    public static final String CONTRACT_ADDRESS_LWC =
            "0xb359a4b15d0daa681320d65be4c9e4eef2ba83c6"; // 合约地址，写到数据库
    public static final String CONTRACT_ADDRESS_MKR =
            "0x9f8f72aa9304c8b593d555f12ef6589cc3a579a2"; // 合约地址，写到数据库
    public static final String CONTRACT_ADDRESS_CNT = "0xcf26188709A8E78243733D1C348950C6ceB6411B";
    public static final String CONTRACT_ADDRESS_ETH = ""; // 合约地址，写到数据库

    public static final String ENTRY_ORDER_TYPE_SELL = "卖出";
    public static final String ENTRY_ORDER_TYPE_BUY = "买入";
    // 代币分类
    public static final int TOKEN_TYPE_ETH = 1; // 以太坊
    public static final int TOKEN_TYPE_BTC = 2; // 比特币
    public static final int TOKEN_TYPE_EOS = 3; // eos
    public static final int TOKEN_TYPE_USDT = 4; // usdt
    // ......
    public static final int TOKEN_TYPE_ETH_COIN = 11; // 以太坊上的代币
    public static final int TOKEN_TYPE_BTC_COIN = 12; // 比特币上的代币
    public static final int TOKEN_TYPE_EOS_COIN = 13; // eos上的代币
    public static final int TOKEN_TYPE_USDT_COIN = 14; // usdt上的代币

    // 代币ID
    public static final int TOKEN_ID_ETH = 1000; // eth
    public static final int TOKEN_ID_USDI = 1001; // usdi

    // 错误代码
    public static final String ERROR_CODE_NO_LOGIN = "未登录,请先登录";
    public static final String ERROR_CODE_LOGINOUT = "登录失效，请重新登录";
    public static final String ERROR_OUT_TIMES_LIMIT = "今日取消订单已超过5次，明天再来吧！";

    // 理财
    public static final String FM_PATH = "http://192.168.0.39:8010";
    public static final String FM_CREATE_PRODUCT = FM_PATH + "/manage-money-matters/asch/second/add";
    public static final String FM_DELETE_PRODUCT = FM_PATH + "/manage-money-matters/asch/second/del";
    public static final String FM_UPDATE_PRODUCT =
            FM_PATH + "/manage-money-matters/asch/second/update";
    public static final String SYSTEM_ID = "HMhs}{><,.;lkdgpodafgjh_674$@69kasfjAIHDk*&$$%#";

    // EOS钱包
    public static final String EOS_UNIT = " EOS";
    public static final String EOS_PATH = "http://47.75.102.137:8585";
    public static final String EOS_CREATE_SECRET = EOS_PATH + "/eos/createSecret";
    public static final String EOS_CREATE_WALLET = EOS_PATH + "/eos/createWallet";
    public static final String EOS_CREATE_ACCOUNT = EOS_PATH + "/eos/createAccount";
    public static final String EOS_IMPORT_SECRET = EOS_PATH + "/eos/importSecret";
    public static final String EOS_IMPORT_PRIVATE_KEY = EOS_PATH + "/eos/importPrivateKey";
    public static final String EOS_BUYRAW = EOS_PATH + "/eos/buyram";
    public static final String EOS_SELLRAW = EOS_PATH + "/eos/sellram";
    public static final String EOS_DELEGATEBW = EOS_PATH + "/eos/delegatebw";
    public static final String EOS_UNDELEGATEBW = EOS_PATH + "/eos/undelegatebw";
    public static final String EOS_GET_BALANCE = EOS_PATH + "/eos/getbalance";
    public static final String EOS_GET_ACCOUNT = EOS_PATH + "/eos/getAccount";
    public static final String EOS_TRANSFER = EOS_PATH + "/eos/transfer";
    public static final String PLATFORM_TOKEN_NAME = "TUR"; // 平台币名
    public static final String TOKEN_TAI_NAME = "TAI"; // 平台币名
    public static final String PLATFORM_NAME = "TURING"; // 平台名
    public static final String PLATFORM_TAI_NAME = "ETH"; // 平台名
    // 比特币钱包
    public static final String BTC_UNIT = " BTC";
    public static final String BTC_PATH = "http://47.75.115.154:8585";
    public static final String BTC_GET_BALANCE = BTC_PATH + "/getBalance";
    public static final String BTC_TRANSFER = BTC_PATH + "/sendTransactions";
    public static final String BTC_CREATE_WALLET = BTC_PATH + "/createWallet";
    public static final String BTC_CREATE_SECRET = BTC_PATH + "/createSecret";
    public static final String BTC_IMPORT_WALLET = BTC_PATH + "/importWallet";

    // 钱包类型
    public static final int WALLET_TYPE_ETH = 1;
    public static final int WALLET_TYPE_EOS = 2;
    public static final int WALLET_TYPE_BTC = 3;
    public static final int WALLET_TYPE_USDT = 4;

    // 发币账户转出手续费
    public static final BigDecimal WITHDRAW_FEE_ETH = BigDecimal.valueOf(0.01); // 以太坊
    public static final BigDecimal WITHDRAW_FEE_USDI = BigDecimal.valueOf(20); // USDI
    public static final BigDecimal WITHDRAW_FEE_CNT = BigDecimal.valueOf(10); // CNT

    // 融云
    public static final String RONG_GET_TOKEN = "/user/getToken.json";
    // 火币
    public static final String HUO_URL = "https://api.huobi.pro/market/history/kline";
    // BTC
    public static final String HUO_SYMBOL_LIST_BTC = "symbol=btcusdt&size=1000&period=";
    public static final String HUO_SYMBOL_BTC = "symbol=btcusdt&period=1min&size=1";
    // ETH
    public static final String HUO_SYMBOL_LIST_ETH = "symbol=ethusdt&size=1000&period=";
    public static final String HUO_SYMBOL_ETH = "symbol=ethusdt&period=1min&size=1";
    // LTC
    public static final String HUO_SYMBOL_LIST_LTC = "symbol=ltcusdt&size=1000&period=";
    public static final String HUO_SYMBOL_LTC = "symbol=ltcusdt&period=1min&size=1";
    // XRP
    public static final String HUO_SYMBOL_LIST_XRP = "symbol=xrpusdt&size=1000&period=";
    public static final String HUO_SYMBOL_XRP = "symbol=xrpusdt&period=1min&size=1";
    // EOS
    public static final String HUO_SYMBOL_LIST_EOS = "symbol=eosusdt&size=1000&period=";
    public static final String HUO_SYMBOL_EOS = "symbol=eosusdt&period=1min&size=1";

    /**
     * ** 发布生命链的账号（需要添加权限表写到数据库）
     *
     * @param userId
     * @return
     */
    public static boolean isInLifeChain(long userId) {
        if (userId == 1000000000
                || userId == 1000000002
                || userId == 1000000003
                || userId == 1000000004) {
            return true;
        }
        return false;
    }

    /**
     * * 去掉小数点
     *
     * @param digits 位数
     * @param data
     * @return
     */
    public static Double getDouble(Integer digits, Double data) {
        if (data == null) {
            return null;
        }
        return new BigDecimal(data)
                .setScale(digits == null ? 6 : digits, BigDecimal.ROUND_DOWN)
                .doubleValue();
    }
}
