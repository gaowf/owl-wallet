package com.turing.wallet.enums;


import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Optional;

/**
 * api 返回结果类型.
 */
public enum ApiResultType {
    NotLogin("10000", "rtNotLogin", "not login."),
    SystemError("10001", "rtSystemError", "System Error. Please Contact The System Administrator."),
    Success("0", "rtSuccess", "success"),
    SignFail("10046", "rtSignFail", "sign fail."),
    ParamError("10003", "rtParameterError", "param error."),
    UploadFail("20001", "rtUploadFail", "upload fail."),
    UploadFailFileNameError("90001", "uploadFailFileNameError", "Upload file format wrong"),
    STORE_FAIL("10099", "storeFail", "store fail."),
    ;

    private String code;
    private String configKey;
    private String message;

    ApiResultType(String code, String configKey, String message) {
        this.code = code;
        this.configKey = configKey;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getConfigKey() {
        return configKey;
    }

    public void setConfigKey(String configKey) {
        this.configKey = configKey;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 通过value获取configKey
     */
    public static String getConfigKeyByValue(String code) {
        if (StringUtils.isEmpty(code)) {
            return "";
        }
        Optional<ApiResultType> first =
                Arrays.stream(ApiResultType.values())
                        .filter(e -> e.getCode().equalsIgnoreCase(code))
                        .findFirst();

        if (first.isPresent()) {
            return first.get().getConfigKey();
        }

        return "";
    }

    /**
     * 通过configKey获取备注
     */
    public static String getMessageByConfigKey(String configKey) {
        if (StringUtils.isEmpty(configKey)) {
            return "";
        }
        Optional<ApiResultType> first =
                Arrays.stream(ApiResultType.values())
                        .filter(e -> e.getConfigKey().equalsIgnoreCase(configKey))
                        .findFirst();

        if (first.isPresent()) {
            return first.get().getMessage();
        }

        return "";
    }
}
