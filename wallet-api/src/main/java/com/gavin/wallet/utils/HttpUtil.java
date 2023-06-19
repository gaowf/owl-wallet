package com.turing.wallet.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * http 请求
 */
public class HttpUtil {
    //发送请求
    /*
     * @发送消息
     * @return 结果
     *
     * */
    public static String post(String requestUrl, String accessToken, String params)
            throws Exception {
        //设置contentType
        String contentType = "application/x-www-form-urlencoded";
        return HttpUtil.post(requestUrl, accessToken, contentType, params);
    }


    public static String post(String requestUrl, String accessToken, String contentType, String params)
            throws Exception {
        //设置编码格式为UTF-8
        String encoding = "UTF-8";
        if (requestUrl.contains("nlp")) {
            //如果向使用NLP，就要使用GBK编码，这个是百度api是必须要求的
            encoding = "GBK";
        }
        //返回
        return HttpUtil.post(requestUrl, accessToken, contentType, params, encoding);
    }

    public static String postGeneralUrl(String generalUrl, String contentType, String params, String encoding)
            throws Exception {
        //构造URL
        URL url = new URL(generalUrl);
        //构造HttpURLConnection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        //设置Content-Type
        connection.setRequestProperty("Content-Type", contentType);
        //设置连接信息
        connection.setRequestProperty("Connection", "Keep-Alive");
        connection.setUseCaches(false);

        connection.setDoOutput(true);
        connection.setDoInput(true);
        //发送请求请求内容
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        out.write(params.getBytes(encoding));
        out.flush();
        //关闭
        out.close();
        //连接
        connection.connect();
        //将请求的头打印出来
        Map<String, List<String>> headers = connection.getHeaderFields();
        for (String key : headers.keySet()) {
            System.err.println(key + "--->" + headers.get(key));
        }

        BufferedReader in = null;
        //得到结果
        in = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), encoding));
        String result = "";
        String getLine;
        //将结果取出来
        while ((getLine = in.readLine()) != null) {
            result += getLine;
        }
        in.close();
        //将结果打印出来，返回结果
        System.err.println("result:" + result);
        //返回结果
        return result;
    }

    /*
     * @
     *
     * */
    public static String post(String requestUrl, String accessToken, String contentType, String params, String encoding)
            throws Exception {
        //构造请求url，将请求信息写入url中
        String url = requestUrl + "?access_token=" + accessToken;
        //返回
        return HttpUtil.postGeneralUrl(url, contentType, params, encoding);
    }

    public static BigDecimal sendGet(String url, String param) throws IOException {
        HttpGet request = new HttpGet(url + "?" + param);
        return send(request);
    }

    public static String sendGet2(String url, String param) throws IOException {
        HttpGet request = new HttpGet(url + "?" + param);
        return send2(request);
    }

    private static BigDecimal send(HttpRequestBase request) throws IOException {
        String message = "";
        BigDecimal setScale = null;
        request.setHeader("User-Agent", "Mozilla/5.0  (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.75 Safari/537.36");
        request.setHeader("accept", "*/*");
        request.setHeader("connection", "Keep-Alive");
        request.setHeader("Content-Type", "application/x-www-form-urlencoded");
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = httpclient.execute(request);
        HttpEntity entity = response.getEntity();
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        if (entity != null) {
            long length = entity.getContentLength();
            if (length != -1 && length < 2048) {
                message = EntityUtils.toString(entity);
            } else {
                InputStream in = entity.getContent();
                byte[] data = new byte[4096];
                int count;
                while ((count = in.read(data, 0, 4096)) != -1) {
                    outStream.write(data, 0, count);
                }
                message = new String(outStream.toByteArray(), "UTF-8");
                if (null == message || !message.contains("data")) {
                    return new BigDecimal(0);
                }
                List list = JSONObject.parseObject(message).getJSONArray("data");
                if (list.size() == 0) {
                    return new BigDecimal(0);
                }
                String close = JSONObject.parseObject(list.get(0).toString()).getString("close");
                BigDecimal decimal = new BigDecimal(close);
                setScale = decimal.setScale(4, BigDecimal.ROUND_HALF_UP);
            }
        }
        return setScale;
    }

    private static String send2(HttpRequestBase request) throws IOException {
        String message = "";
        BigDecimal setScale = null;
        request.setHeader("User-Agent", "Mozilla/5.0  (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.75 Safari/537.36");
        request.setHeader("accept", "*/*");
        request.setHeader("connection", "Keep-Alive");
        request.setHeader("Content-Type", "application/x-www-form-urlencoded");
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = httpclient.execute(request);
        HttpEntity entity = response.getEntity();
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        if (entity != null) {
            long length = entity.getContentLength();
            if (length != -1 && length < 2048) {
                message = EntityUtils.toString(entity);
            } else {
                InputStream in = entity.getContent();
                byte[] data = new byte[4096];
                int count;
                while ((count = in.read(data, 0, 4096)) != -1) {
                    outStream.write(data, 0, count);
                }
                message = new String(outStream.toByteArray(), "UTF-8");
            }
        }
        return message;
    }
}

