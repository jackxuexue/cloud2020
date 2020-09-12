package com.jackxue.controller;

import com.jackxue.common.AjaxResult;
import com.jackxue.entities.Order;
import com.jackxue.ribben.MyBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/consumer")
@Slf4j
public class CosumerController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private MyBalance myBalance;

    @GetMapping("/playment/createOrder")
    public AjaxResult createOrder(Order order){
        System.out.println(order);
        return restTemplate.postForObject(PAYMENT_URL + "/playment/createOrder", order, AjaxResult.class);
    }

    @GetMapping("/playment/getOrder/{id}")
    public AjaxResult getOrder(@PathVariable("id") String id){
        return restTemplate.getForObject(PAYMENT_URL + "/playment/getOrder/" + id, AjaxResult.class);
    }

    @GetMapping("/playment/lb")
    public String testLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance instance = myBalance.instance(instances);
        return restTemplate.getForObject(instance.getUri() + "playment/lb", String.class);
    }
}
