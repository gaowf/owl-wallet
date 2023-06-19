package com.turing.wallet.utils;


import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StringUtils;

import javax.net.ssl.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * HttpClient客户端
 */
@Slf4j
public class HttpClientUtils<T> {

    private static final String UTF_8 = "UTF-8";

    private static HttpClientBuilder clientBuilder = null;

    static {
        clientBuilder = HttpClients.custom();
        clientBuilder.setConnectionTimeToLive(120,TimeUnit.SECONDS);
        clientBuilder.setMaxConnTotal(50);

        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(30000)
                .setConnectTimeout(30000)
                .setConnectionRequestTimeout(30000)
                .build();
        clientBuilder.setDefaultRequestConfig(requestConfig);
    }

    public static CloseableHttpClient getHttpClient(){
        CloseableHttpClient httpClient = clientBuilder.build();
        return httpClient;
    }

    /**
     * get请求
     */
    public static <T> T getHttpToObj(String url, Class<T> clazz) throws Exception {
        CloseableHttpClient client = null;
        HttpGet get = null;
        String result = "";
        try {
            client = getHttpClient();
            get = new HttpGet(url);
            HttpResponse resp = client.execute(get);
            HttpEntity entity = resp.getEntity();
            result = EntityUtils.toString(entity, UTF_8);
            return JSON.parseObject(result, clazz);
        } catch (Exception e) {
            log.error(e.toString(), e);
            return null;
        } finally {
            //关闭连接，释放资源
            if (get != null) {
                get.releaseConnection();
            }
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    log.error(e.toString(), e);
                }
            }
        }
    }

    /**
     * post请求-参数
     */
    public static <T> T postHttpToObj(String url, Map<String, String> paramMap, Class<T> clazz) throws Exception {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        if (paramMap != null) {
            for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        String result = postHttp(url,null,  new UrlEncodedFormEntity(params, UTF_8));
        if(StringUtils.isEmpty(result)){
            throw new Exception("call picVideo service return value is null.");
        }
        return JSON.parseObject(result, clazz);
    }

    /**
     * post请求-参数
     */
    public static String postHttp(String url, Header[] headers, Map<String, String> paramMap) throws Exception {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        if (paramMap != null) {
            for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        String result = postHttp(url, headers, new UrlEncodedFormEntity(params, UTF_8));

        return result;
    }

    /**
     * post请求
     */
    private static String postHttp(String url, Header[] headers, HttpEntity formEntity) {
        CloseableHttpClient client = null;
        HttpPost post = null;
        String result = "";
        try {
            client = getHttpClient();
            //HttpClient httpClient = new DefaultHttpClient();
            post = new HttpPost(url);
            if(headers != null) {
                post.setHeaders(headers);
            }
            post.setEntity(formEntity);
            HttpResponse resp = client.execute(post);
            HttpEntity entity = resp.getEntity();
            result = EntityUtils.toString(entity, UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭连接，释放资源
            //httpClient.getConnectionManager().shutdown();httpClient = null;
            if (post != null) {
                post.releaseConnection();
            }
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * get请求
     */
    public static String getHttp(String url) {
        CloseableHttpClient client = null;
        HttpGet get = null;
        String result = "";
        try {
            client = getHttpClient();
            get = new HttpGet(url);
            HttpResponse resp = client.execute(get);
            HttpEntity entity = resp.getEntity();
            result = EntityUtils.toString(entity, UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭连接，释放资源
            if (get != null) {
                get.releaseConnection();
            }
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * get请求
     */
    public static String getHttp(String url,Header[] headers) {
        CloseableHttpClient client = null;
        HttpGet get = null;
        String result = "";
        try {
            client = getHttpClient();
            get = new HttpGet(url);
//            get.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0"); // 设置请求头消息User-Agent
            get.setHeaders(headers);
            HttpResponse resp = client.execute(get);
            HttpEntity entity = resp.getEntity();
            result = EntityUtils.toString(entity, UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭连接，释放资源
            if (get != null) {
                get.releaseConnection();
            }
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * post请求
     */
    public static String postHttpForJH(String url, HttpEntity formEntity) {
        CloseableHttpClient client = null;
        HttpPost post = null;
        String result = "";
        try {
            client = HttpClients.createDefault();
            post = new HttpPost(url);
            post.setEntity(formEntity);
            HttpResponse resp = client.execute(post);
            HttpEntity entity = resp.getEntity();
            result = EntityUtils.toString(entity, UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭连接，释放资源
            //httpClient.getConnectionManager().shutdown();httpClient = null;
            if (post != null) {
                post.releaseConnection();
            }
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * post Json
     * @param url
     * @param headers
     * @param message
     * @return
     */
    public static String postJson(String url, Header[] headers, String message) {
        HttpPost httppost = null;
        String result = null;
        try {
            SSLContext sslcontext = createIgnoreVerifySSL();
            // 设置协议http和https对应的处理socket链接工厂的对象
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.INSTANCE)
                    .register("https", new SSLConnectionSocketFactory(sslcontext)).build();
            PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(
                    socketFactoryRegistry);
            HttpClients.custom().setConnectionManager(connManager);
            CloseableHttpClient httpclients = HttpClients.custom().setConnectionManager(connManager).build();
            httppost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(20000).setConnectTimeout(5000).build(); // 设置超时
            httppost.setConfig(requestConfig);
            httppost.setHeaders(headers);
            httppost.setEntity(new StringEntity(message, StandardCharsets.UTF_8));
            CloseableHttpResponse response = httpclients.execute(httppost);
            if (null != response) {
                try {
                    result = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                    if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                        result = null;
                    }
                } finally {
                    response.close();
                }
            }
        } catch (Exception e) {
            log.error("postJson|error", e);
        } finally {
            try {
                if (null != httppost) {
                    httppost.releaseConnection();
                }
            } catch (Exception e) {
                log.error("【postJson】｜POST URL:[{}] 关闭httpclient.close()异常[{}]!", url, e.getStackTrace());
            }
        }
        return result;
    }

    /**
     * 绕过验证
     */
    private static SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sc = SSLContext.getInstance("TLSv1.2");

        // 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
        X509TrustManager trustManager = new X509TrustManager() {
            @Override
            public void checkClientTrusted(java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                                           String paramString) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                                           String paramString) throws CertificateException {
            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };

        sc.init(null, new TrustManager[] { trustManager }, null);
        return sc;
    }

    public static void main(String[] args) {
        System.out.println(doGetByNoSSL("https://api.etherscan.io/api?module=gastracker&action=gasoracle&apikey=WUYEQT8HEREQ9AXUZ42GVC1UKC1TCCP7GD"));
        //System.out.println(getHttp("https://api.etherscan.io/api?module=gastracker&action=gasoracle&apikey=WUYEQT8HEREQ9AXUZ42GVC1UKC1TCCP7GD"));
    }

    public static String doGetByNoSSL(String url)  {
        try {
            //声明
            ProtocolSocketFactory fcty = new MySecureProtocolSocketFactory();
            //加入相关的https请求方式
            Protocol.registerProtocol("https", new Protocol("https", fcty, 443));
            //发送请求即可
            org.apache.commons.httpclient.HttpClient httpclient = new org.apache.commons.httpclient.HttpClient();
            HttpConnectionManagerParams params = httpclient.getHttpConnectionManager().getParams();
            params.setConnectionTimeout(50000);
            params.setSoTimeout(50000);
            GetMethod httpget = new GetMethod(url);
            //System.out.println("======url:" + url);
            try {
                httpclient.executeMethod(httpget);
                return httpget.getResponseBodyAsString();
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new Exception(ex.getMessage());
            } finally {
                httpget.releaseConnection();
            }
        } catch (Exception ex){
            log.error(ex.toString(),ex);
            return null;
        }
    }
}
