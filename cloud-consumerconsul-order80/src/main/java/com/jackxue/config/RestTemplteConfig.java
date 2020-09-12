package com.jackxue.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplteConfig {

    @Bean
    public RestTemplate getRestTemple(){
        return new RestTemplate();
    }
}
