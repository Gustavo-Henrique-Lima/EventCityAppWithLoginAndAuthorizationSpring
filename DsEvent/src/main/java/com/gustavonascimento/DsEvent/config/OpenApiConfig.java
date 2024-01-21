package com.gustavonascimento.DsEvent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@OpenAPIDefinition
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI dsEventWithLoginAndAuthorization() {
        return new OpenAPI()
           .info(new Info()
           .title("API de eventos com login e autorização")
           .description("API criada para avaliação do terceiro capitulo do BootCamp Spring 3.0")
           .version("v0.0.1")
           .license(new License()
           .name("Apache 2.0")
           .url("https://github.com/Gustavo-Henrique-Lima")));
    }
}