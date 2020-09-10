package com.jackxue.mapper;

import com.jackxue.entities.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {
    public abstract int addOrder(Order order);
    public abstract Order getOrderById(@Param("id") int id);
}
