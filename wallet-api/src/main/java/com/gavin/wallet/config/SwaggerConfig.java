package com.turing.wallet.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.turing.wallet.constants.Const.EXCH_TOKEN;
import static java.util.Collections.singletonList;

/**
 * Swagger 配置
 *
 * @author wangleichao
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${turing.swagger.switch:true}")
    private boolean swaggerSwitch;

    @Value("${info.app.name:NOT_SET}")
    public String appName;
    @Value("${info.env.name:NOT_SET}")
    public String envName;

    private static final String USER_TOKEN_HEADER = EXCH_TOKEN;

    /**
     * Swagger API 配置
     */
    @Bean
    public Docket createSwaggerDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerSwitch)
                .securitySchemes(apiKeys())
                .securityContexts(singletonList(securityContext()))
                .apiInfo(apiInfo())
                .select()
                .paths(acceptPath("/v2/**"))
                .build();
    }

    protected List<ApiKey> apiKeys() {
        return Arrays.asList(
                new ApiKey(USER_TOKEN_HEADER, USER_TOKEN_HEADER, "header")
        );
    }

    protected SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .build();
    }

    protected List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[]{authorizationScope};

        List<SecurityReference> references = new ArrayList<>();
        references.add(new SecurityReference(USER_TOKEN_HEADER, authorizationScopes));
        return references;
    }


    private Predicate<String> acceptPath(String... patterns) {
        return Predicates.or(Arrays.stream(patterns).map(PathSelectors::ant).collect(Collectors.toList()));
    }

    /**
     * 接口返回值使用驼峰
     */
/*    @Bean
    public HttpMessageConverter<Object> createHttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        converter.setObjectMapper(objectMapper);
        return converter;
    }*/

    /**
     * Swagger UI 信息设置
     */
    private ApiInfo apiInfo() {
        Contact contact = new Contact("OPPO WALLET", "xxx", "xxx");
        return new ApiInfoBuilder()
                .title(appName)
                .description(String.format("appName:%s / env:%s", appName, envName))
                .version("v1.0")
                .contact(contact)
                .license("Commercial")
                .build();
    }
}
