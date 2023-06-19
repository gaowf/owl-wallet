package com.turing.wallet.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

/**
 * @author fengjiahao
 */
@Component
@Slf4j
public class HttpServiceProxy {

    @Autowired
    @Qualifier("retryRestTemplateProxy")
    private RestTemplate retryRestTemplate;

    public String doRequest(String url, String json, HttpMethod httpMethod) {
        RequestEntity<String> requestEntity = enrichRequestEntity(url, json, httpMethod, null);
        ResponseEntity<String> responseEntity = doRequest(requestEntity);
        return responseEntity.getBody();
    }

    public String doRequest(String url, String json, HttpMethod httpMethod, Map map) {
        RequestEntity<String> requestEntity = enrichRequestEntity(url, json, httpMethod, map);
        ResponseEntity<String> responseEntity = doRequest(requestEntity);
        return responseEntity.getBody();
    }

    public String postFormRequest(String url, Map<String, String> map) {
        String responseBody = "";
        HttpEntity requestEntity = null;
        try {
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);

            requestEntity = new HttpEntity(toMultiValueMap(map), headers);
            ResponseEntity<String> responseEntity = retryRestTemplate.postForEntity(url, requestEntity, String.class);
            responseBody = responseEntity.getBody();
        } catch (Exception e) {
            log.error("url: " + url, e);
            throw new RuntimeException("请求上游失败");
        }

        return responseBody;
    }

    private RequestEntity<String> enrichRequestEntity(String url, String json, HttpMethod httpMethod, Map map) {
        URI uri = UriComponentsBuilder.fromHttpUrl(url).build().encode().toUri();
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        if (map != null && map.size() > 0) {
            headers = toMultiValueMap(map);
        }
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        return new RequestEntity<>(json, headers, httpMethod, uri);
    }

    public <T> ResponseEntity<String> doRequest(RequestEntity<T> requestEntity) {
        ResponseEntity<String> responseEntity;
        try {
            log.info("do request: " + JsonUtil.toLogJson(requestEntity));
            responseEntity = retryRestTemplate.exchange(requestEntity, String.class);
            log.info("response body: " + responseEntity.getBody());
            return responseEntity;
        } catch (ResourceAccessException e) {
            throw e;
        } catch (Exception e) {
            log.error("url: " + requestEntity.getUrl(), e);
            throw new RuntimeException("请求上游失败");
        }
    }

    private MultiValueMap<String, String> toMultiValueMap(Map<String, String> map) {
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            multiValueMap.add(entry.getKey(), entry.getValue());
        }
        return multiValueMap;
    }

}
