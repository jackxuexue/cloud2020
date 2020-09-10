package com.jackxue.service;

import com.jackxue.entities.Order;

public interface OrderService {
    public abstract int createOrder(Order order);
    public abstract Order getOrderById(int id);
}
