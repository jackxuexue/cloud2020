package com.jackxue.controller;

import com.jackxue.common.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

    private static String INVOKE_URL = "http://consul-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public AjaxResult paymentTest(){
//        return AjaxResult.success("ok");
        return restTemplate.getForObject(INVOKE_URL + "/payment/consul", AjaxResult.class);
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
