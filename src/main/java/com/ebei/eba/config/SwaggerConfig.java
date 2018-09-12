package com.ebei.eba.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangsm
 * @version 1.0
 * @created 2018/4/17
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        ParameterBuilder tokenBuilder = new ParameterBuilder();
        List<Parameter> parameterList = new ArrayList<Parameter>();
//        tokenBuilder.name("Authorization")
//                .defaultValue("去其他请求中获取head中token参数")
//                .description("令牌")
//                .modelRef(new ModelRef("string"))
//                .parameterType("header")
//                .required(true).build();
//        parameterList.add(tokenBuilder.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(parameterList);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("能源系统API")
                .description("能源系统 Energy Swagger API")
                .termsOfServiceUrl("http://www.ebeitech.com") //一碑门户
                .version("1.0.0")
                .build();
    }

}