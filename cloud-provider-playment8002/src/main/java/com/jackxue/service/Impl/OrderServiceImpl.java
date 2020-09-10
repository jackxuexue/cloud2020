package com.jackxue.service.Impl;

import com.jackxue.entities.Order;
import com.jackxue.mapper.OrderMapper;
import com.jackxue.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int createOrder(Order order) {
        return orderMapper.addOrder(order);
    }

    @Override
    public Order getOrderById(int id) {
        return orderMapper.getOrderById(id);
    }
}
