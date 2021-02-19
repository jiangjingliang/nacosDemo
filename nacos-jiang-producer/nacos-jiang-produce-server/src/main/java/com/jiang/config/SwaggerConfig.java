package com.jiang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/***
 * 访问：http://192.168.0.103:1991/swagger-ui.html#
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket userApi() {

        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("Authorization").description("token令牌:Bearer").defaultValue("Bearer ").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jiang.controller"))//过滤的接口
                .paths(PathSelectors.any())
                /*.antMatchers("/v2/api-docs",//swagger api json
                        "/swagger-resources/configuration/ui",//用来获取支持的动作
                        "/swagger-resources",//用来获取api-docs的URI
                        "/swagger-resources/configuration/security",//安全选项
                        "/swagger-ui.html",
                        "/webjars/**").permitAll()*/
                .build().globalOperationParameters(pars);
        return docket;
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("生成者").description("服务相关数据接口")
                .termsOfServiceUrl("http://localhost:1991")
                .license("Licence Version 1.0").licenseUrl("#").version("1.0").build();
    }

}