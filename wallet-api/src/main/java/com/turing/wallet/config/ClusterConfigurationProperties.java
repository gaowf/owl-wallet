package com.turing.wallet.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * redis 配置.
 */
@Component
@ConfigurationProperties(prefix = "spring.redis.cluster")
public class ClusterConfigurationProperties {
    /**
     * spring.redis.cluster.nodes[0] = 127.0.0.1:7379 spring.redis.cluster.nodes[1] = 127.0.0.1:7380
     * ...
     */
    private List<String> nodes;

    private Boolean dynamicRefreshSources;

    /**
     * Get initial collection of known cluster nodes in format.
     *
     * @code host:port .
     */
    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }

    public Boolean getDynamicRefreshSources() {
        return dynamicRefreshSources;
    }

    public void setDynamicRefreshSources(Boolean dynamicRefreshSources) {
        this.dynamicRefreshSources = dynamicRefreshSources;
    }
}
