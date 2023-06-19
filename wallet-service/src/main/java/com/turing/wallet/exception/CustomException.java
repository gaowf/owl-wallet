package com.turing.wallet.exception;

/**
 * 签名异常.
 */
public class CustomException extends Exception {

    private String code;

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    //
}
