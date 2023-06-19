package com.turing.wallet.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: gaowf
 * @Date: 2023/4/27 下午6:11
 */
@Data
public class ChainAddrCurrency implements Serializable {

    @ApiModelProperty("币种id")
    private Long id;

    @ApiModelProperty("币种")
    private String currency;

    @ApiModelProperty("钱包对应的币种名")
    private String walletCurrencyName;

    @ApiModelProperty("币种图标")
    private String iconAddress;

    @ApiModelProperty("币合约地址")
    private String contractAddress;

    @ApiModelProperty("币类型 0:默认不生成地址 1:默认生成地址 2:自定义币")
    private Integer currencyType;

    @ApiModelProperty("创建时间")
    private Date ctime;
}
