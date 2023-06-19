package com.turing.wallet.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 加密.
 */
@Data
@Component
@ConfigurationProperties(value = "sign")
public class SignConfig {
    private String sys_server_sign_url;
    private String sys_server_sign_key;
}
