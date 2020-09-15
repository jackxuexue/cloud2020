package com.jackxue.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public String paymentOk(Integer id){
        return "线程：" + Thread.currentThread().getName() + "paymentOk, id" + id;
    }

    public String paymentTimeout(Integer id){
//        int i = 10/0;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程：" + Thread.currentThread().getName() + "paymentTimeout, id" + id;
    }

    //兜底方法
    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池："+Thread.currentThread().getName()+"   系统繁忙, 请稍候再试  ,id：  "+id+"\t"+"哭了哇呜";
    }
}
