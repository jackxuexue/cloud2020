package com.jackxue.controller;

import com.jackxue.common.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PlaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/consul")
    public AjaxResult paymentConsul(){
        return AjaxResult.success("springcloud with consul: "+serverPort+"\t"+ UUID.randomUUID().toString());
    }
}
