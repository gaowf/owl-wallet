package com.turing.wallet.utils;

public class Json {

    private String msg = "失败";
    private boolean suc = false;
    private Object result;

    public Json() {

    }

    public static Json rs(String msg, Object result, boolean suc) {
        return new Json(msg, result, suc);
    }

    public static Json rs(String msg) {
        return new Json(msg);
    }

    public Json(String msg) {
        this.msg = msg;

    }

    public Json(String msg, Object result) {
        this.msg = msg;
        this.result = result;
    }

    public Json(String msg, Object result, boolean suc) {
        this.msg = msg;
        this.result = result;
        this.suc = suc;
    }

    public Json(Object result) {

        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuc() {
        return suc;
    }

    public void setSuc(boolean suc) {
        this.suc = suc;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

}
