package com.cooler.ai.platform.service;

import com.cooler.ai.burouter.OrderGroupInfo;

import java.util.List;

/**
 * @Author zhangsheng
 * @Description
 * @Date 2019/12/11
 **/

public interface OrderGroupService {

    List<OrderGroupInfo> getOrderByUserIdState(String userId, int state);

    OrderGroupInfo getOrderById(Integer orderId);

    OrderGroupInfo saveOrder(OrderGroupInfo orderGroupInfo);

    int updateOrder(OrderGroupInfo orderGroupInfo);

    List<OrderGroupInfo> selectOrderGroups(String userId, int state, int startId, int count);

    List<Integer> selectOrderGroupIds(String userId, int state);
}
