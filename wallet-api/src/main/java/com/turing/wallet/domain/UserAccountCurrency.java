package com.turing.wallet.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class UserAccountCurrency implements Serializable {

    @ApiModelProperty("账号id")
    private Long accountId;

    @ApiModelProperty("账号名称")
    private String accountName;

    @ApiModelProperty("账号说明")
    private String accountRemark;

    @ApiModelProperty("创建时间")
    private Date ctime;

    @ApiModelProperty("账号链地址列表")
    private List<UserChainAddr> chainAddrList;
}
