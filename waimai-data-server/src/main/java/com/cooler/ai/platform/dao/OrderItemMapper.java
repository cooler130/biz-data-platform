package com.cooler.ai.platform.dao;

import com.cooler.ai.platform.entity.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface OrderItemMapper {

    List<OrderItem> getOrderItemsByOrderIds(@Param("orderIds") List<Integer> orderIds);

    Integer save(OrderItem orderItem);

    List<OrderItem> getOrderItemsByUserIdOrderIds(@Param("userId") String userId, @Param("orderIds") Set<Integer> orderIds);
}