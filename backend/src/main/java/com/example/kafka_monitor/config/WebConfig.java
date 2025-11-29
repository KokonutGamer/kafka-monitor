package com.example.kafka_monitor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/api/messages/**")
                .allowedMethods("*")
                .allowedOriginPatterns("http://*localhost:[*]", "https://*localhost:[*]")
                .allowCredentials(false);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebConfig();
    }
}
