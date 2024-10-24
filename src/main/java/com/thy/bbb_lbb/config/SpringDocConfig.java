package com.thy.bbb_lbb.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
//    @Value("${version}")
//    private String version;
//
//    @Value("${spring.application.name}")
//    private String serviceName;

    private Info apiInfo() {
        return new Info()
                .title("bbb_lbb API文档")
                .description("CP系统")
                .version("1.0.0");
    }

    @Bean
    public OpenAPI createRestApi() {
        final var api = new OpenAPI()
                .info(apiInfo());
        // token认证
        final var accountScheme = new SecurityScheme()
                .name("account")
                .in(SecurityScheme.In.HEADER)
                .type(SecurityScheme.Type.APIKEY);
        final var accessTokenScheme = new SecurityScheme()
                .name("accessToken")
                .in(SecurityScheme.In.HEADER)
                .type(SecurityScheme.Type.APIKEY);

        api.components(new Components()
                        .addSecuritySchemes("account", accountScheme)
                        .addSecuritySchemes("accessToken", accessTokenScheme))
                .addSecurityItem(new SecurityRequirement().addList("account"))
                .addSecurityItem(new SecurityRequirement().addList("accessToken"));
        return api;
    }
}
