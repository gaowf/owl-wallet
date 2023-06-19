package com.turing.wallet.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: gaowf
 * @Date: 2023/4/27 下午2:36
 */
@Data
public class AccountInfo implements Serializable {

    @ApiModelProperty("账号id")
    private String accountId;

    @ApiModelProperty("账号名称")
    private String accountName;

}
