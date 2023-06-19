package com.turing.wallet.constants;

/**
 * 常量.
 */
public interface Const {
    // 请求头信息

    /**
     * 参数签名.
     */
    String EXCH_SIGNATURE = "exch-signature";

    /**
     * app 语言环境.
     */
    String EXCH_LANGUAGE = "exch-language";

    /**
     * app 版本.
     */
    String APP_VERSION = "app-version";

    /**
     * 请求设备号.
     */
    String EXCH_DEVICE_ID = "exch-Device-ID";

    /**
     * 交易所id.
     */
    String EXCH_ID = "exch-id";

    /**
     * 请求时间 UTC + 0
     */
    String EXCH_TIMESTAMP = "exch-timestamp";

    /**
     * 登录成功的token.
     */
    String EXCH_TOKEN = "OPWT-token";

    /**
     * header中的sign.
     */
    String TRUST_TOKEN = "trust-sign";


    /**
     * 客户端类型: Android / IOS.
     */
    String EXCH_CLIENT_TYPE = "exch-Client-Type";

    /**
     * 用户登录token.
     */
    String TOKEN_USER = "user:token:";

    String CACHE_USER = "cacheUser";

    String ACCOUNT_PREX = "account";
    /**
     * redis config public key
     */
    String APP_CONFIG_PUBLIC_001 = "app_config_public_001";

    /**
     * redis config public key
     */
    String APP_CONFIG_PUBLIC_002 = "app_config_public_002";


    String SYS_CONF_OSS_PATH = "sys_conf_oss_path";

    String SYS_CONF_OSS_API = "sys_conf_oss_api";

    String OSS_FILESUPLOAD_PATH = "filesUpload/";


    String CLIENT_TYPE_IOS = "ios";

    String CLIENT_TYPE_ANDROID = "android";


    /**
     * 汇率缓存前缀.
     */
    String REDIS_RATE_SYMBOL_PREFIX = "rate:";


    /**
     * 公告
     */
    String NOTICE_CACHE_PREFIX = "notice_cache_prefix";

    String LATEST_NOTICE_CACHE_PREFIX = "latest_notice_cache_prefix";

    /**
     * 轮播
     */
    String CAROUSEL_CACHE_PREFIX = "carousel_cache_prefix";

    /**
     * 轮播多语言支持
     */
    String CAROUSEL_CACHE_PREFIX_LANGUAGE = "carousel_cache_prefix_language";

    /**
     * 系统汇率
     */
    String STATS_SYMBOL_RATES = "stats_symbol_rates";

    String STATS_SYMBOL_RATES_EXCHANGE = "stats_symbol_rates_exchange";

    /**
     * 交易所币种信息
     */
    String EXCHANGE_SYSTEM_INFO = "exchange_system_info";

    /**
     * 交易所币种信息配置
     */
    String EXCHANGE_SYSTEM_INFO_CONFIG = "exchange_system_info_config";

    /**
     * 签名配置.
     */
    String SIGN_CONFIG = "sign_config";


    /**
     * 用户信息指纹配置.
     */
    String USER_FINGERPRINT_CONFIG = "user_fingerprint_config";


    /**
     * 验证码超时时间
     */
    Integer CODE_VALID_TIME = 360;


    Integer PAGE_LIMIT_START = 0;


    Integer PAGE_LIMIT_END = 20;

    Long DEFAULT_EXCH_ID = 1L;

    String CMC_SYMBOL_WHITE_LIST = "cmc_symbol_white_list";

    String COINGECKO_SYMBOL_WHITE_LIST = "coingecko_symbol_white_list";

    /**
     * 后台配置 邮箱网关.
     */
    String SYS_CONF_EMAIL_GATEWAY = "sys_conf_email_gateway";

    /**
     * 新上币申请发送的邮箱
     */
    String APPLY_DATA_SEND_EMAIL = "apply_data_send_email";

    /**
     * 上币申请邮箱标题
     */
    String APPLY_EMAIL_SUBJECT = "有新的上币申请，请注意查看！";

    /**
     * 等于此版本号的app强制更新
     */
    String FORCE_UPDATE_APP = "force_update_app";

    /**
     * 金刚区配置
     */
    String KING_KONG_DISTRICT = "king_kong_district";

    public static final int INT_0 = 0;
    public static final int INT_1 = 1;
    public static final int INT_2 = 2;
    public static final int INT_3 = 3;
    public static final int INT_4 = 4;
    public static final int INT_6 = 6;
    public static final int INT_8 = 8;
    public static final int INT_10 = 10;
    public static final int INT_12 = 12;
    public static final int INT_24 = 10;
    public static final int INT_500 = 500;
    public static final byte BYTE_0 = 0;
    public static final byte BYTE_1 = 1;
    public static final byte BYTE_2 = 2;
    public static final byte BYTE_3 = 3;
    public static final byte BYTE_4 = 4;
    public static final byte BYTE_5 = 5;
    public static final byte BYTE_6 = 6;

    public static final String BTC = "BTC";
    public static final String ETH = "ETH";
    public static final String FIL = "FIL";
    public static final String USDT = "USDT";
    public static final String CNY = "CNY";

}
