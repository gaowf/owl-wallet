package com.turing.wallet.bean.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "通用返回结果")
public class ResponseBase<T> implements Serializable {

    public static final int STATUS_SUCCESS = 1;

    private static final long serialVersionUID = 1L;

    public static ResponseBase buildErrorResponse(int status, String message) {
        return new ResponseBase(status, message);
    }

    public static ResponseBase buildErrorResponse(ResponseStatus responseStatus) {
        return new ResponseBase(responseStatus.getStatus(), responseStatus.getName());
    }

    public static ResponseBase buildErrorResponse(String message) {
        return new ResponseBase(0, message);
    }

    public static ResponseBase buildErrorResponse(String message, Object data) {
        ResponseBase responseBase = buildErrorResponse(message);
        responseBase.setData(data);
        return responseBase;
    }

    @ApiModelProperty(value = "status", name = "status")
    private int status;
    @ApiModelProperty(value = "message", name = "message")
    private String message;

    @ApiModelProperty(value = "响应数据", name = "data")
    private T data;

    public ResponseBase() {
        this.status = 1;
        this.message = "成功";
    }

    public ResponseBase(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseBase(String message, T data) {
        this();
        this.message = message;
        this.data = data;
    }

    public ResponseBase(int status, String message, T data) {
        this();
        this.status = status;
        this.message = message;
        this.data = data;
    }


    public ResponseBase(T data) {
        this();
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ResponseBase [status=" + status + ", message=" + message + ", data=" + data + "]";
    }

}
