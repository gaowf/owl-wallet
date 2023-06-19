package com.turing.wallet.config;

import io.lettuce.core.cluster.ClusterClientOptions;
import io.lettuce.core.cluster.ClusterTopologyRefreshOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

@Component
public class RedisConfig {

    /**
     * Type safe representation of application.properties
     */
    private ClusterConfigurationProperties clusterConfigurationProperties;

    private RedisProperties redisProperties;

    @Autowired
    public RedisConfig(
            RedisProperties redisProperties,
            ClusterConfigurationProperties clusterConfigurationProperties) {
        this.clusterConfigurationProperties = clusterConfigurationProperties;
        this.redisProperties = redisProperties;
    }

    /**
     * redisTemplate.
     *
     * @param redisConnectionFactory redisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<?, ?> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        redisTemplate.setValueSerializer(getValueSerializer());
        redisTemplate.setHashValueSerializer(getValueSerializer());

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());

        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(redisConnectionFactory);
        return stringRedisTemplate;
    }

    /**
     * RedisConnectionFactory.
     */
    public @Bean
    RedisConnectionFactory connectionFactory() {

        RedisClusterConfiguration configuration =
                new RedisClusterConfiguration(clusterConfigurationProperties.getNodes());
        configuration.setPassword(RedisPassword.of(redisProperties.getPassword()));

        ClusterTopologyRefreshOptions topologyRefreshOptions =
                ClusterTopologyRefreshOptions.builder()
                        .dynamicRefreshSources(clusterConfigurationProperties.getDynamicRefreshSources())
                        .build();

        LettuceClientConfiguration lettuceClientConfiguration =
                LettucePoolingClientConfiguration.builder()
                        .clientOptions(
                                ClusterClientOptions.builder()
                                        .topologyRefreshOptions(topologyRefreshOptions)
                                        .build())
                        .build();

        return new LettuceConnectionFactory(configuration, lettuceClientConfiguration);
    }

    private RedisSerializer getValueSerializer() {
        return new GenericJackson2JsonRedisSerializer();
    }
}
