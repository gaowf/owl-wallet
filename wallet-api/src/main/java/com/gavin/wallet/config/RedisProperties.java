package com.turing.wallet.config;

import java.time.Duration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * redis 配置 RedisProperties.
 */
@Component
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedisProperties {
    private String password;
    private Duration timeout;
}
