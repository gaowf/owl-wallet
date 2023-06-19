package com.turing.wallet.config;

import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClient;
import com.amazonaws.services.kms.AWSKMSClientBuilder;
import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConditionalOnMissingBean(AWSKMS.class)
@ConfigurationProperties(value = "aws")
public class AwsKmsConfig {

    private String kms_key_id;
    private String kms_algorithm;

    @Bean
    public AWSKMS kms() {
        final AWSKMSClientBuilder builder = AWSKMSClient.builder();

//        if (Optional.ofNullable(properties.getEndpoint()).isPresent()) {
//            builder.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(properties.getEndpoint().getServiceEndpoint(), properties.getEndpoint().getSigningRegion()));
//        } else {
//            Optional.ofNullable(properties.getRegion()).ifPresent(builder::setRegion);
//        }

        return builder.build();
    }
}
