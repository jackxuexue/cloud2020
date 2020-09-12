package com.jackxue.ribben.Impl;

import com.jackxue.ribben.MyBalance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyBalanceImpl implements MyBalance {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private final int getNextValue(){
        int current = 0;
        int next = 0;
        do {
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        }while (!atomicInteger.compareAndSet(current, next));
        System.out.println("第几次请求：" + next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> instances) {
        if(instances == null || instances.size() <= 0){
            return null;
        }
        return instances.get(getNextValue()%instances.size());
    }
}
