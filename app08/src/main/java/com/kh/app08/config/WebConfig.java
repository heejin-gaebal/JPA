package com.kh.app08.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry
                .addMapping("/**") //모든 url, 모든 &포인트에 대해 동작하게 함
                .allowedOrigins("http://localhost:5173")
                .allowedMethods("GET" , "POST" , "PUT" , "DELETE" , "OPTIONS")
                .allowCredentials(true);
    }
}
