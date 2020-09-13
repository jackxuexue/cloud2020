package com.jackxue.controller;

import com.jackxue.common.AjaxResult;
import com.jackxue.service.ConsumerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private ConsumerOrderService orderService;

    @GetMapping("/consumer/payment/get/{id}")
    public AjaxResult getPaymentById(@PathVariable("id") Long id){
        return orderService.getPaymentById(id);
    }

    @GetMapping("/consumer/fegin/timeout")
    public String timeoutTest(){
        return orderService.timeoutTest();
    }
}
