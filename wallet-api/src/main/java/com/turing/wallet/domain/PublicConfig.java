package com.turing.wallet.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: gaowf
 * @Date: 2023/4/27 下午2:36
 */
@Data
public class PublicConfig implements Serializable {

    @ApiModelProperty("币列表")
    private List<ChainInfo> chainList;

}
