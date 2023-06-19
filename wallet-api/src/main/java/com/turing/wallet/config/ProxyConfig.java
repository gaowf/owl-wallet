package com.turing.wallet.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 代理配置.
 */
@Data
@Component
@ConfigurationProperties(value = "proxy")
public class ProxyConfig {
    private final String enable = "1";
    private String flag = "0";
    private String host;
    private Integer port;

    public boolean enable() {
        return enable.equalsIgnoreCase(flag);
    }
}
