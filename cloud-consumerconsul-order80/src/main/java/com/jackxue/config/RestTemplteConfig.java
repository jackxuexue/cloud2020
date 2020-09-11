package com.jackxue.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplteConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemple(){
        return new RestTemplate();
    }
}
