package com.turing.wallet.param;

import lombok.Data;

/**
 * @Author: gaowf
 * @Date: 2023/4/27 下午9:17
 */
@Data
public class QuotePriceQuery {

    private String symbol;

    private String convert;
}
