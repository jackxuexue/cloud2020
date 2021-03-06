package com.jackxue.controller;

import com.jackxue.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "globalFallBack", commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
})
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentOk(@PathVariable("id") Integer id){
        String result = orderService.paymentOk(id);
        log.info("*******result:"+result);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")  //3秒钟以内就是正常的业务逻辑
    })
//    @HystrixCommand
    public String paymentTimeout(@PathVariable("id") Integer id){
        String result = orderService.paymentTimeout(id);
        log.info("*******result:"+ result);
        return result;
    }

    //兜底方法
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
        return "jack==="+"我是消费者80，对付支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,(┬＿┬)";
    }

    @GetMapping("/consumer/payment/hystrix/testHystrix/{id}")
    @HystrixCommand  //如果要使用服务降级之类的必须打开这个宏，可以使用默认的降级
    public String paymentTestHystrix(@PathVariable("id") Integer id){
//        String result = "test";
        String result = orderService.paymentTestHystrix(id);
        log.info("*******result:"+ result);
        return result;
    }

    /**
     * 全局降级处理函数
     * @param
     * @return
     */
    public String globalFallBack(){
        return "globalFallBack ===================";
    }
}
