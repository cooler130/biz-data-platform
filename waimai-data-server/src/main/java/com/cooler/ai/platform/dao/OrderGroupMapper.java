package com.cooler.ai.platform.dao;

import com.cooler.ai.platform.entity.OrderGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderGroupMapper {
    //获取userId名下，状态为state的订单，如果state为-1，则获取所有订单
    List<OrderGroup> getOrderByUserId(@Param("userId") String userId, @Param("state") int state);

    int saveOrder(OrderGroup order);

    int updateOrder(OrderGroup order);

    OrderGroup getOrderById(@Param("orderId") Integer orderId);

    List<OrderGroup> selectOrderGroups(@Param("userId") String userId, @Param("state") int state, @Param("startId") int startId, @Param("count") int count);

    List<Integer> selectOrderGroupIds(@Param("userId") String userId, @Param("state") int state);
}