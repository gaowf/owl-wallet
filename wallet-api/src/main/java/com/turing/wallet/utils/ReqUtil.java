package com.turing.wallet.utils;

/**
 * Created by 00000 on 2019/1/11.
 */

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharArrayBuffer;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 2018/4/1.
 */
@Service
public class ReqUtil {


    public String btcRPC(String month, List params) {
        String body = "";
        try {
//创建请求
            CloseableHttpClient httpclient = HttpClients.createDefault();
//使用post方式
            HttpPost httpPost = new HttpPost();
//构建请求参数等信息

            Map method = new HashMap();
            method.put("method", month);//方法名
            method.put("params", params);
            method.put("id", UUID.randomUUID());
            httpPost.setEntity(new StringEntity(JSONObject.toJSON(method).toString(), ContentType.create("application/json", "UTF-8")));
//RPC服务地址、端口
            httpPost.setURI(new URI("http://localhost:8808"));
//RPC认证信息用户名、密码
            String userpasswor = org.apache.commons.codec.binary.Base64.encodeBase64String("admin:123456".getBytes());
            httpPost.setHeader(new BasicHeader("Authorization", "Basic" + " " + userpasswor));
//发送请求
            CloseableHttpResponse response = httpclient.execute(httpPost, new BasicHttpContext());
//解析返回结果
            HttpEntity resEntity = response.getEntity();

            if (resEntity != null) {
                body = toString(resEntity, ContentType.get(resEntity));
                ;
            }
            System.out.println(body);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return body;
    }

    public String btcRPCs(String month, List params, String filename) {
        String body = "";
        try {
//创建请求
            CloseableHttpClient httpclient = HttpClients.createDefault();
//使用post方式
            HttpPost httpPost = new HttpPost();
//构建请求参数等信息

            Map method = new HashMap();
            method.put("method", month);//方法名
            method.put("params", params);
            method.put("id", UUID.randomUUID());
            httpPost.setEntity(new StringEntity(JSONObject.toJSON(method).toString(), ContentType.create("application/json", "UTF-8")));
//RPC服务地址、端口
            httpPost.setURI(new URI("http://localhost:8808/wallet/" + filename));
//RPC认证信息用户名、密码
            String userpasswor = org.apache.commons.codec.binary.Base64.encodeBase64String("admin:123456".getBytes());
            httpPost.setHeader(new BasicHeader("Authorization", "Basic" + " " + userpasswor));
//发送请求
            CloseableHttpResponse response = httpclient.execute(httpPost, new BasicHttpContext());
//解析返回结果
            HttpEntity resEntity = response.getEntity();

            if (resEntity != null) {
                body = toString(resEntity, ContentType.get(resEntity));
            }
            System.out.println(body);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return body;
    }

    private static String toString(HttpEntity entity, ContentType contentType) throws IOException {
        InputStream instream = entity.getContent();
        if (instream == null) {
            return null;
        } else {
            try {
                int capacity = (int) entity.getContentLength();
                if (capacity < 0) {
                    capacity = 4096;
                }

                Charset charset = null;
                if (contentType != null) {
                    charset = contentType.getCharset();
                    if (charset == null) {
                        ContentType defaultContentType = ContentType.get(entity);
                        charset = defaultContentType != null ? defaultContentType.getCharset() : null;
                    }
                }

                if (charset == null) {
                    charset = HTTP.DEF_CONTENT_CHARSET;
                }

                Reader reader = new InputStreamReader(instream, charset);
                CharArrayBuffer buffer = new CharArrayBuffer(capacity);
                char[] tmp = new char[1024];

                int l;
                while ((l = reader.read(tmp)) != -1) {
                    buffer.append(tmp, 0, l);
                }

                String var9 = buffer.toString();
                return var9;
            } finally {
                instream.close();
            }
        }
    }

    public String getBtcFree() {
        String body = "";
        try {
//创建请求
            CloseableHttpClient httpclient = HttpClients.createDefault();
//使用post方式
            HttpPost httpPost = new HttpPost();
            httpPost.setURI(new URI("https://bitcoinfees.earn.com/api/v1/fees/recommended"));
//发送请求
            CloseableHttpResponse response = httpclient.execute(httpPost, new BasicHttpContext());
//解析返回结果
            HttpEntity resEntity = response.getEntity();

            if (resEntity != null) {
                body = toString(resEntity, ContentType.get(resEntity));
                ;
            }
            System.out.println(body);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return body;
    }

    public String file(String url) {
        ArrayList<String> columnList = new ArrayList<String>();
        // 使用ArrayList来存储每行读取到的字符串
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            FileReader fr = new FileReader(url);
            BufferedReader bf = new BufferedReader(fr);
            String str;
            // 按行读取字符串
            while ((str = bf.readLine()) != null) {
                arrayList.add(str);
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 返回数组
        return arrayList.get(8);
    }

    public String getRandomString(int length) {
        //定义一个字符串（A-Z，a-z，0-9）即62位；
        String str = "zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        //由Random生成随机数
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        //长度为几就循环几次
        for (int i = 0; i < length; ++i) {
            //产生0-61的数字
            int number = random.nextInt(62);
            //将产生的数字通过length次承载到sb中
            sb.append(str.charAt(number));
        }
        //将承载的字符转换成字符串
        return sb.toString();
    }

    public boolean isConSpeChar(String str) {

        String regEx = "[`~!@#$%^&*()+=|{}':;'\\[\\]<>/?~！@#￥%……&*——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }

    public String request(HttpServletRequest request) {
        String param = null;
        try {
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);

            JSONObject jsonObject = JSONObject.parseObject(responseStrBuilder.toString());
            param = jsonObject.toJSONString();
            System.out.println(param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return param;
    }

}
