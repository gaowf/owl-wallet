package com.turing.wallet.bean.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 返回信息
 *
 * @param <T> 回应对象
 * @author wangleichao
 */
@ApiModel(value = "返回值包装类")
public class ResponseDTO<T> {

    @ApiModelProperty(value = "状态码")
    protected int status;

    @ApiModelProperty(value = "错误消息")
    protected String message;

    @ApiModelProperty(value = "实际返回数据")
    protected T data;

    @ApiModelProperty(value = "成功失败标识")
    protected boolean success;

    public ResponseDTO() {
    }

    public ResponseDTO(ResponseCodeConst succ, String msg) {
        super();
        this.status = succ.getCode();
        this.message = msg;
        this.success = succ.isSuccess();
    }

    private ResponseDTO(int code, String msg) {
        this.status = code;
        this.message = msg;
    }

    public ResponseDTO(int code, String msg, T data) {
        super();
        this.status = code;
        this.message = msg;
        this.data = data;
    }

    private ResponseDTO(ResponseCodeConst responseCodeConst) {
        this.status = responseCodeConst.getCode();
        this.message = responseCodeConst.getMsg();
        this.success = responseCodeConst.isSuccess();
    }

    public ResponseDTO(int code, String msg, T data, boolean success) {
        this.status = code;
        this.message = msg;
        this.data = data;
        this.success = success;
    }

    public static <T> ResponseDTO<T> succ() {
        return new ResponseDTO<T>(ResponseCodeConst.SUCC);
    }

    public static <T> ResponseDTO<T> succ(T t) {
        return new ResponseDTO<T>(ResponseCodeConst.SUCC.getCode(), ResponseCodeConst.SUCC.getMsg(), t, ResponseCodeConst.SUCC.isSuccess());
    }

    public static <T> ResponseDTO<T> succMsg(String msg) {
        return new ResponseDTO<T>(ResponseCodeConst.SUCC, msg);
    }

    public static <T> ResponseDTO<T> succData(T t) {
        return new ResponseDTO<T>(ResponseCodeConst.SUCC.getCode(), ResponseCodeConst.SUCC.getMsg(), t, ResponseCodeConst.SUCC.isSuccess());
    }

    public static <T> ResponseDTO<T> succStr(T t) {
        return new ResponseDTO<T>(ResponseCodeConst.SUCC.getCode(), ResponseCodeConst.SUCC.getMsg(), t, ResponseCodeConst.SUCC.isSuccess());
    }


    public static <T> ResponseDTO<T> wrap(ResponseCodeConst codeConst) {
        return new ResponseDTO<>(codeConst.getCode(), codeConst.getMsg());
    }

    public static <T> ResponseDTO<T> wrapData(ResponseCodeConst codeConst, T t) {
        return new ResponseDTO<T>(codeConst.getCode(), codeConst.getMsg(), t);
    }

    public static <T> ResponseDTO<T> wrapMsg(ResponseCodeConst codeConst, String msg) {
        return new ResponseDTO<T>(codeConst.getCode(), msg);
    }

    public static <T> ResponseDTO<T> wrap(ResponseDTO<T> responseDTO) {
        return responseDTO;
    }

    public String getMsg() {
        return message;
    }

    public void setMsg(String msg) {
        this.message = msg;
    }

    public int getCode() {
        return status;
    }

    public T getData() {
        return data;
    }

    public void setCode(int code) {
        this.status = code;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "AdjustResponseDTO{" +
                "code=" + status +
                ", msg='" + message + '\'' +
                ", data=" + data +
                ", success=" + success +
                '}';
    }
}
