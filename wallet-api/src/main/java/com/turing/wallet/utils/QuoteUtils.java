package com.turing.wallet.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static com.turing.wallet.constants.Const.INT_0;

@Slf4j
public class QuoteUtils {

    private static String apiKey = "94cd35dd-6348-4701-8bb1-69f8ddc37a46";

    private static String uri = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest";

    private static  CloseableHttpClient client = HttpClients.createDefault();

    public static void main(String[] args) {

        System.out.println(getLastPrice("USDT","CNY"));
        System.out.println(getLastPrice("BTC","USD"));
    }

    public static String getLastPrice(String symbol,String convert){
        List<NameValuePair> paratmers = new ArrayList<NameValuePair>();
        paratmers.add(new BasicNameValuePair("symbol",symbol));
        paratmers.add(new BasicNameValuePair("convert",convert));
        String result = null;
        try {
            result = makeAPICall(uri, paratmers);
            JSONObject jsonObject = JSON.parseObject(result);
            if(jsonObject != null && ((Integer)(jsonObject.getJSONObject("status").get("error_code")) == 0)){
                JSONObject jb2 =  jsonObject.getJSONObject("data").getJSONObject(symbol).getJSONObject("quote").getJSONObject(convert);
                BigDecimal rateValue = (BigDecimal)jb2.get("price");
                result = rateValue.toPlainString();
            }
        } catch (IOException e) {
            log.error("Error: cannont access content - " + e.toString());
        } catch (URISyntaxException e) {
            log.error("Error: Invalid URL " + e.toString());
        }
        return result;
    }

    private static String makeAPICall(String uri, List<NameValuePair> parameters)
            throws URISyntaxException, IOException {
        String response_content = "";

        URIBuilder query = new URIBuilder(uri);
        query.addParameters(parameters);

        HttpGet request = new HttpGet(query.build());

        request.setHeader(HttpHeaders.ACCEPT, "application/json");
        request.addHeader("X-CMC_PRO_API_KEY", apiKey);

        CloseableHttpResponse response = client.execute(request);

        try {
            //System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            response_content = EntityUtils.toString(entity);
            EntityUtils.consume(entity);
        } finally {
            response.close();
        }

        return response_content;
    }

}