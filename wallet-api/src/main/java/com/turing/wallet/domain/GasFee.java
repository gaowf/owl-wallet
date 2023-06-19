package com.turing.wallet.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: gaowf
 * @Date: 2023/4/27 下午6:11
 */
@Data
public class GasFee implements Serializable {
    private BigDecimal fastGasPrice;
    private BigDecimal slowGasPrice;
    private BigDecimal proposeGasPrice;
}
