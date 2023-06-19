package com.turing.wallet.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
@ConfigurationProperties(prefix = "pooling.connection")
@Data
public class PoolingConnectionProperties {
    /**
     * Determines the timeout in milliseconds until a connection is established.
     */
    int connectTimeout = 30000;
    /**
     * The timeout when requesting a connection from the connection manager.
     */
    int requestTimeout = 30000;
    /**
     * The timeout for waiting for data
     */
    int socketTimeout = 30000;
    int maxTotalConnections = 21000;
    int defaultMaxPerRoute = 7000;
    int defaultKeepAliveTimeMillis = 20000;
    int closeIdleConnectionWaitTimeSecs = 30;
}
