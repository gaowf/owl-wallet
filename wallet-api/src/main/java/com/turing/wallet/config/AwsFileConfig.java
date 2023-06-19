package com.turing.wallet.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * AWS 配置文件
 */
@Component
@ConfigurationProperties(prefix = "aws.file")
@Getter
@Setter
public class AwsFileConfig {

  private String accessKey;
  private String secretKey;
  private String bucketName;
  private String accessPrefix;
  private String region;
}
