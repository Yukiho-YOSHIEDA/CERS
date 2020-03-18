package dev.yukiho.cers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Setting Swagger-ui
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket dock() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .build()
                .useDefaultResponseMessages(false)
                .host("localhost")
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("CERS API Spec")
                .version("0.1")
                .build();
    }
}
