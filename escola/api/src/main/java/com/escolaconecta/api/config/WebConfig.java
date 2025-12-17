package com.escolaconecta.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Libera todas as rotas da API
                .allowedOrigins("*") // Libera para qualquer site/IP acessar (Apenas para dev)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS"); // Libera esses métodos
    }
}