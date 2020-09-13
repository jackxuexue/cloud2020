package com.jackxue.service;

import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallback implements OrderService {

    @Override
    public String paymentOk(Integer id) {
        return "HystrixClientFallback paymentOk 超时处理降级处理";
    }

    @Override
    public String paymentTimeout(Integer id) {
        return "HystrixClientFallback paymentTimeout 超时处理降级处理";
    }

    @Override
    public String paymentTestHystrix(Integer id) {
        return "HystrixClientFallback paymentTestHystrix 超时处理降级处理";
    }
}
