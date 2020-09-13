package com.jackxue.controller;

import com.jackxue.common.AjaxResult;
import com.jackxue.entities.Order;
import com.jackxue.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/playment")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Value("${server.port}")
    private String port;

    @PostMapping("/createOrder")
    public AjaxResult createOrder(@RequestBody Order order){
        int ret = orderService.createOrder(order);
        return AjaxResult.success("创建成功" + port, ret);
    }

    @GetMapping("/getOrder/{id}")
    public AjaxResult getOrder(@PathVariable("id") int id){
//        Order orderById = orderService.getOrderById(id);
        return AjaxResult.success("查询成功" + port, UUID.randomUUID().toString());
    }

    @GetMapping("/lb")
    public String getLb(){
        return port;
    }

    @GetMapping("/feign/timeout")
    public String timeouttest(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port;
    }
}
