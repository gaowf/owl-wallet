package com.turing.wallet.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Author: gaowf
 * @Date: 2023/4/27 下午9:17
 */
@Data
public class ChainAddrSetParam implements Serializable {

    @ApiModelProperty("账号id")
    @NotBlank(message = "accountId is mandatory")
    private String accountId;

    @ApiModelProperty("链id")
    @NotBlank(message = "chainId is mandatory")
    private Long chainId;

    @ApiModelProperty("链地址")
    @NotBlank(message = "address is mandatory")
    private String address;

}
