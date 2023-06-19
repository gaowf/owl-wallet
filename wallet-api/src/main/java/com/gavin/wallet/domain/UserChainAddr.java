package com.turing.wallet.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class UserChainAddr implements Serializable {

    @ApiModelProperty("链id")
    private Long chainId;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("链名称")
    private String chainName;

    @ApiModelProperty("链显示名")
    private String chainShowName;

    @ApiModelProperty("链图标地址")
    private String chainIconAddress;

    @ApiModelProperty("链协议")
    private String chainProtocol;

    @ApiModelProperty("链浏览器地址")
    private String chainBrowserAddress;

    @ApiModelProperty("创建时间")
    private Date ctime;

    @ApiModelProperty("链对应币种列表")
    private List<ChainAddrCurrency> currencyList;

}
