package com.jackxue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.jackxue.mapper")
@EnableEurekaClient
public class PayMent8002Application {
    public static void main(String[] args) {
        SpringApplication.run(PayMent8002Application.class, args);
    }
}
