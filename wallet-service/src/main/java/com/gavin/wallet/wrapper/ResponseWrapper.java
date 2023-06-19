package com.turing.wallet.wrapper;

import com.turing.wallet.enums.ApiResultType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 请求返回
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("返回对象")
public class ResponseWrapper<T> {

    /**
     * 200 成功, 非 200 具体异常码.
     */
    @ApiModelProperty("0 成功, 非 0 具体异常码")
    private String code;

    /**
     * 返回描述.
     */
    @ApiModelProperty("返回描述")
    private String message;

    /**
     * 返回数据.
     */
    @ApiModelProperty("返回数据")
    private T data;

    public static <T> ResponseWrapperBuilder<Object> success() {
        return success(new HashMap<>(1));
    }

    public static <T> ResponseWrapperBuilder<Object> success(T data) {
        return builder().data(data);
    }

    public static <K> ResponseWrapper<K> success2(K data) {
        ResponseWrapper<K> response = new ResponseWrapper<K>();
        response.code = ApiResultType.Success.getCode();
        response.data = data;
        return response;
    }

    public static <T> ResponseWrapperBuilder<Object> fail() {
        return builder().data(new HashMap<>(1));
    }
}
