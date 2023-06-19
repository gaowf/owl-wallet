package com.turing.wallet.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.cache.Cache;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * app 配置.
 */
@Configuration
@RefreshScope
public class AppConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().setConnectTimeout(Duration.of(30, ChronoUnit.SECONDS)).build();
    }

    @Bean
    public Cache cache() {
//        final String cacheName = "gateway_buckets";
//        Config config = new Config();
//        CacheSimpleConfig cacheConfig = new CacheSimpleConfig();
//        cacheConfig.setName(cacheName);
//        config.addCacheConfig(cacheConfig);
//
//        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance(config);
//        ICacheManager cacheManager = hazelcastInstance.getCacheManager();
//        return cacheManager.getCache(cacheName);
        return null;
    }
}
