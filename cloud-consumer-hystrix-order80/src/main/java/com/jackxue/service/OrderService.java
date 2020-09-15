package com.jackxue.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT")
public interface OrderService {

    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentOk(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentTimeout(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/testHystrix/{id}")
    String paymentTestHystrix(@PathVariable("id") Integer id);
}



