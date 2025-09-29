package com.gallardo.rest_api_auth.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Rest API Auth")
                        .version("1.0.0")
                        .description("API para autenticación y gestión de usuarios desarrollada con Spring Boot + JPA + MariaDB 🚀")
                );
    }
}
