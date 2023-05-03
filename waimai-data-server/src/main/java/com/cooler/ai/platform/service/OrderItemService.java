package com.cooler.ai.platform.service;

import com.cooler.ai.burouter.OrderItemInfo;

import java.util.List;
import java.util.Set;

/**
 * @Author zhangsheng
 * @Description
 * @Date 2019/12/19
 **/

public interface OrderItemService {

    List<OrderItemInfo> getOrderItemsByOrderIds(List<Integer> orderIds);

    OrderItemInfo save(OrderItemInfo orderItemInfo);

    List<OrderItemInfo> getOrderItemsByUserIdOrderIds(String userId, Set<Integer> orderIds);
}
