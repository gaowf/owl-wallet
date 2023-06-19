package com.turing.wallet.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.turing.wallet.domain.GasFee;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * @Author: gaowf
 * @Date: 2023/4/27 下午8:49
 */
@Slf4j
public class GasUtils {

    private static final String ETH_GAS_URL = "https://api.etherscan.io/api?module=gastracker&action=gasoracle&apikey=WUYEQT8HEREQ9AXUZ42GVC1UKC1TCCP7GD";
    private static final String BSC_GAS_URL = "https://api.bscscan.com/api?module=gastracker&action=gasoracle&apikey=Q1QGCX9R6S98PJFJTY9AWGG1AUDP3GHMEP";

    private static CloseableHttpClient client = HttpClients.createDefault();

    public static void main(String[] args) {

        GasFee gasFee = getGasFee(1);
        if (gasFee != null) {
            System.out.println(JSON.toJSONString(gasFee));
        }
    }

    public static GasFee getGasFee(Integer chainType) {
        String result = null;
        try {
            switch (chainType) {
                case 1:
                    return getEthGasFee();
                case 2:
                    return getBscGasFee();
            }

        } catch (Exception e) {
            log.error(e.toString(), e);
        }
        return null;
    }

    private static GasFee getBscGasFee() {
        String str = HttpClientUtils.doGetByNoSSL(BSC_GAS_URL);
        if(StringUtils.isNotBlank(str)) {
            JSONObject jsonObject = JSON.parseObject(str);
            String status = (String) jsonObject.get("status");
            if (status.equals("1")) {
                JSONObject jst = jsonObject.getJSONObject("result");
                GasFee gasFee = new GasFee();
                gasFee.setProposeGasPrice(jst.getBigDecimal("ProposeGasPrice"));
                gasFee.setFastGasPrice(jst.getBigDecimal("FastGasPrice"));
                gasFee.setSlowGasPrice(jst.getBigDecimal("SafeGasPrice"));
                return gasFee;
            }
        }
        return null;
    }

    private static GasFee getEthGasFee() {
        String str = HttpClientUtils.doGetByNoSSL(ETH_GAS_URL);
        if(StringUtils.isNotBlank(str)) {
            JSONObject jsonObject = JSON.parseObject(str);
            Integer status = (Integer) jsonObject.get("status");
            if (status == 1) {
                JSONObject jst = JSON.parseObject("result");
                GasFee gasFee = new GasFee();
                gasFee.setProposeGasPrice(jst.getBigDecimal("ProposeGasPrice"));
                gasFee.setFastGasPrice(jst.getBigDecimal("FastGasPrice"));
                gasFee.setSlowGasPrice(jst.getBigDecimal("SafeGasPrice"));
                return gasFee;
            }
        }
        return null;
    }
}
