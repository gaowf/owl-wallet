//package com.turing.wallet.utils;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import lombok.extern.slf4j.Slf4j;
//
//import java.math.BigDecimal;
//import java.math.RoundingMode;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//import static com.exch.schedule.constants.ScheduleConstants.*;
//import static com.turing.wallet.constants.Const.*;
//
//
//@Slf4j
//public class CoinUtils {
//
//    private static final String ETH_GAS_URL = "https://api.etherscan.io/api?module=gastracker&action=gasoracle&apikey=WUYEQT8HEREQ9AXUZ42GVC1UKC1TCCP7GD";
//
//    private static final String COINTOCNY = "https://api.coinmarketcap.com/v2/ticker/?structure=array&convert=CNY";
//
//
//    private static Map<String,BigDecimal> preCoinCnyRateMap = new ConcurrentHashMap<String,BigDecimal>();
//
//    public static void main(String[] args) throws Exception {
////        log.info("yesterday unit hashrate income:"+getBtcUnitHashrateIncome());
////        log.info("hashrate:" + getBtcBlockHashrate());
////        log.info("difficulty:" + getBtcBlockDifficulty());
////        log.info("BlockHeight:" + getBtcBlockHeight());
//        log.info(getCoinToUSDT(FIL).toPlainString());
//    }
//
//    public static BigDecimal getCoinToUSDT(String currency){
//        BigDecimal usdtPrice = getCoinToCNYRate(USDT);
//        BigDecimal currencyPrice = getCoinToCNYRate(currency);
//        BigDecimal value = currencyPrice.divide(usdtPrice,8, RoundingMode.DOWN);
//        log.info("getCoinToUSDT {}={}USDT",currency,value);
//        return value;
//    }
//
//    public static BigDecimal getCoinToCNYRate(String currency) {
//        return getCNYRateFromCoco(currency);
//    }
//
//
//
//    private static BigDecimal getCNYRateFromCoinmarketcap(String currency) {
//        try {
//            String str = HttpClientUtils.getHttp(COINTOCNY);
//            JSONObject jsonObject = JSON.parseObject(str);
//            JSONArray jsonArray = jsonObject.getJSONArray("data");
//            for(int i=INT_0;i<jsonArray.size();i++) {
//                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
//                String symbol = jsonObject1.getString("symbol");
//                if(symbol.equals(currency)){
//                    JSONObject jsonObject2 =  jsonObject1.getJSONObject("quotes").getJSONObject("CNY");
//                    BigDecimal rateValue = (BigDecimal)jsonObject2.get("price");
//                    preCoinCnyRateMap.put(currency,rateValue);
//                    return preCoinCnyRateMap.get(currency);
//                }
//            }
//            return preCoinCnyRateMap.get(currency);
//        } catch (Exception ex) {
//            log.error(ex.toString(), ex);
//            return preCoinCnyRateMap.get(currency);
//        }
//    }
//
//    public static BigDecimal getBtcUnitHashrateIncome() {
//        BigDecimal result = null;
//        int retryCount = INT_1;
//        while(retryCount <= INT_3 && result == null){  //重试3次
//            result = getBtcUnitHashrateIncomeNew();
//            if(result == null){
//                try {
//                    Thread.sleep(200l); //暂停200毫秒
//                }
//                catch (Exception ex){
//                    log.error(ex.toString(),ex);
//                }
//            }
//            retryCount = retryCount + INT_1;
//        }
//        return result;
//    }
//
//    public static BigDecimal getBtcUnitHashrateIncomeOld() {
//        try {
//            String str = HttpClientUtils.getHttp(UNIT_HASHRATE_INCOME);
//            log.info("读取BTC.com获取昨日收益结果:{}",str);
//            JSONObject jsonObject = JSON.parseObject(str);
//            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
//            String earningsYesterday = jsonObject1.getString("earnings_yesterday");
//            JSONObject jsonObject2 = jsonObject1.getJSONObject("hashrate_yesterday");
//            String size = jsonObject2.getString("size");
//            String unit = jsonObject2.getString("unit");
//            if(!unit.equals("T")){
//               return null;
//            }
//            BigDecimal total = new BigDecimal(earningsYesterday).multiply(new BigDecimal("0.00000001")).multiply(new BigDecimal(0.99));
//            BigDecimal result = total.divide(new BigDecimal(size),INT_8, RoundingMode.DOWN);
//            return result;
//        } catch (Exception ex) {
//            log.error("get BtcUnitHashrateIncome fail:"+ex.toString(), ex);
//            return null;
//        }
//    }
//
//    public static BigDecimal getBtcUnitHashrateIncomeNew() {
//        try {
//            String str = HttpClientUtils.getHttp("https://pool.btc.com/v1/coins-income");
//            log.info("读取BTC.com新接口获取昨日收益结果:{}",str);
//            JSONObject jsonObject = JSON.parseObject(str);
//            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
//            JSONObject jsonObject2 = jsonObject1.getJSONObject("btc");
//            String incomeCoin = jsonObject2.getString("income_optimize_coin");
//            String unit = jsonObject2.getString("income_hashrate_unit");
//            if(!unit.equals("T")){
//                return null;
//            }
//            BigDecimal total = new BigDecimal(incomeCoin).multiply(new BigDecimal(0.965));
//            BigDecimal result = BigDecimalUtils.bigDecimal2RoundDown(total,8);
//            return result;
//        } catch (Exception ex) {
//            log.error("get BtcUnitHashrateIncome fail:"+ex.toString(), ex);
//            return null;
//        }
//    }
//
//}
