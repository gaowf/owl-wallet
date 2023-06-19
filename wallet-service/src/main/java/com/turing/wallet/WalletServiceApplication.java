package com.turing.wallet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.turing.wallet.config.AwsKmsConfig;
import com.turing.wallet.config.KmsEncryptablePropertyDetector;
import com.turing.wallet.config.KmsEncryptablePropertyResolver;
import com.ulisesbocchio.jasyptspringboot.EncryptablePropertyDetector;
import com.ulisesbocchio.jasyptspringboot.EncryptablePropertyResolver;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.hazelcast.HazelcastAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.MultipartConfigElement;
import java.util.Properties;

@RestController
@EnableFeignClients(basePackages = {"com.coinbull.cacheclient"})
@SpringBootApplication(exclude = { HazelcastAutoConfiguration.class})
@MapperScan({"com.turing.wallet.mapper"})
@ComponentScan(
        basePackages = {
                "com.turing.wallet",
                "com.coinbull.cacheclient.service"
        })
@EnableAspectJAutoProxy
@EnableDiscoveryClient
@EnableTransactionManagement
@EnableCaching
@EnableAsync
public class WalletServiceApplication extends SpringBootServletInitializer {

    private static Logger log = LoggerFactory.getLogger(WalletServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WalletServiceApplication.class, args);
        log.info("项目已启动");
    }

    @RequestMapping("/")
    public String index() {
        JSONObject job = new JSONObject();
        job.put("code", 0);
        job.put("message", "success");
        return JSON.toJSONString(job);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }

    // 分页插件
    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        p.setProperty("dialect", "mysql");
        pageHelper.setProperties(p);
        return pageHelper;
    }

    @Bean(name = "encryptablePropertyDetector")
    public EncryptablePropertyDetector encryptablePropertyDetector() {
        return new KmsEncryptablePropertyDetector();
    }

    @Bean(name = "encryptablePropertyResolver")
    @DependsOn(value = {"awsKmsConfig"})
    public EncryptablePropertyResolver encryptablePropertyResolver(AwsKmsConfig awsKmsConfig) {
        return new KmsEncryptablePropertyResolver(awsKmsConfig);
    }

    /**
     * 文件上传配置
     *
     * @return
     */
    @SuppressWarnings("deprecation")
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 单个文件最大
        factory.setMaxFileSize(DataSize.of(50, DataUnit.MEGABYTES)); // KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.of(50, DataUnit.MEGABYTES));
        return factory.createMultipartConfig();
    }
}
