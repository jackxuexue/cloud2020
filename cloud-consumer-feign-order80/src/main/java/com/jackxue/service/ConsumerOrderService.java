package com.jackxue.service;

import com.jackxue.common.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface ConsumerOrderService {
    @GetMapping(value = "/playment/getOrder/{id}")
    public abstract AjaxResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "playment/feign/timeout")
    public abstract String timeoutTest();
}
