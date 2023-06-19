package com.turing.wallet.domain;

import cn.hutool.core.date.DateTime;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author: gaowf
 * @Date: 2023/4/27 下午2:36
 */
@Data
public class ChainInfo {

    @ApiModelProperty("链id")
    private Long chainId;

    @ApiModelProperty("链名称")
    private String chainName;

    @ApiModelProperty("链图标")
    private String chainIconAddress;

    @ApiModelProperty("链协议")
    private String chainProtocol;

    @ApiModelProperty("创建时间")
    private Long createdAt;

    @ApiModelProperty("创建时间")
    private Long updatedAt;

    @ApiModelProperty("币列表")
    private List<CurrencyInfo> currencyList;

}
