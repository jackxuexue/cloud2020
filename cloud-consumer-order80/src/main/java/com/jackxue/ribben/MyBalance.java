package com.jackxue.ribben;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface MyBalance {
    public abstract ServiceInstance instance(List<ServiceInstance> instances);
}
