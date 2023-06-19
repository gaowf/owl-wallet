package com.turing.wallet.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: gaowf
 * @Date: 2023/4/27 下午2:36
 */
@Data
public class CurrencyDO {

    @ApiModelProperty("币种id")
    private Long id;

    @ApiModelProperty("币种")
    private String currencyCode;

    @ApiModelProperty("币种图标")
    private String iconAddress;

    @ApiModelProperty("链id")
    private Long chainId;

    @ApiModelProperty("链名称")
    private String chainName;

    @ApiModelProperty("链图标")
    private String chainIconAddress;

    @ApiModelProperty("链协议")
    private String chainProtocol;

    @ApiModelProperty("钱包币种名称")
    private String walletCurrencyName;

    @ApiModelProperty("合约地址")
    private String contractAddress;

    @ApiModelProperty("币种类型(0:默认不生成地址 1:默认生成地址 2:自定义币")
    private Integer currencyType;

    @ApiModelProperty("创建时间")
    private Long createdAt;

    @ApiModelProperty("修改时间")
    private Long updatedAt;
}
