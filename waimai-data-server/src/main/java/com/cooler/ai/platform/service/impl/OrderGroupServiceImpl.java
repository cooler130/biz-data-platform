package com.cooler.ai.platform.service.impl;

import com.cooler.ai.platform.dao.OrderGroupMapper;
import com.cooler.ai.platform.entity.OrderGroup;
import com.cooler.ai.platform.model.OrderDataInfo;
import com.cooler.ai.platform.model.OrderGroupInfo;
import com.cooler.ai.platform.service.OrderGroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhangsheng
 * @Description
 * @Date 2019/12/11
 **/
@Service("orderService")
public class OrderGroupServiceImpl implements OrderGroupService {
    @Resource
    private OrderGroupMapper orderMapper;

    @Override
    public List<OrderGroupInfo> getOrderByUserIdState(String userId, int state) {
        List<OrderGroup> orderGroups = orderMapper.getOrderByUserId(userId, state);
        List<OrderGroupInfo> orderGroupInfos = new ArrayList<>();
        for (OrderGroup orderGroup : orderGroups) {
            OrderGroupInfo orderGroupInfo = convertOrderGroupInfo(orderGroup);
            orderGroupInfos.add(orderGroupInfo);
        }
        return orderGroupInfos;
    }

    @Override
    public OrderGroupInfo getOrderById(Integer orderId) {
        OrderGroup order = orderMapper.getOrderById(orderId);
        return convertOrderGroupInfo(order);
    }

    @Override
    public OrderGroupInfo saveOrder(OrderGroupInfo orderGroupInfo) {
        OrderGroup orderGroup = convertOrderGroup(orderGroupInfo);
        orderMapper.saveOrder(orderGroup);
        if(orderGroup != null && orderGroup.getId() != null){
            OrderGroupInfo orderGroupInfoOut = convertOrderGroupInfo(orderGroup);
            return orderGroupInfoOut;
        }
        return null;
    }

    @Override
    public int updateOrder(OrderGroupInfo orderInfo) {
        int id = orderMapper.updateOrder(convertOrderGroup(orderInfo));
        return id;
    }

    @Override
    public List<OrderGroupInfo> selectOrderGroups(String userId, int state, int startId, int count) {
        List<OrderGroup> orderGroups = orderMapper.selectOrderGroups(userId, state, startId, count);
        if(orderGroups == null) return null;

        List<OrderGroupInfo> orderGroupInfos = new ArrayList<>();
        for (OrderGroup orderGroup : orderGroups) {
            OrderGroupInfo orderGroupInfo = convertOrderGroupInfo(orderGroup);
            orderGroupInfos.add(orderGroupInfo);
        }
        return orderGroupInfos;
    }

    @Override
    public List<Integer> selectOrderGroupIds(String userId, int state) {
        List<Integer> orderIds = orderMapper.selectOrderGroupIds(userId, state);
        return orderIds;
    }

    private OrderGroup convertOrderGroup(OrderGroupInfo orderInfo){
        OrderGroup order = new OrderGroup();
        order.setId(orderInfo.getId());
        order.setOrderCode(orderInfo.getOrderCode());
        order.setUserId(orderInfo.getUserId());
        order.setUserName(orderInfo.getUserName());
        order.setTotalPrice(orderInfo.getTotalPrice());
        order.setSkuCount(orderInfo.getSkuCount());
        order.setAddressId(orderInfo.getAddressId());
        order.setAddress(orderInfo.getAddress());
        order.setMsg(orderInfo.getMsg());
        order.setCreateTimestamp(orderInfo.getCreateTimestamp());
        order.setPayTimestamp(orderInfo.getPayTimestamp());
        order.setState(orderInfo.getState());
        return order;

    }

    private OrderGroupInfo convertOrderGroupInfo(OrderGroup order){
        OrderGroupInfo orderInfo = new OrderGroupInfo();
        orderInfo.setId(order.getId());
        orderInfo.setOrderCode(order.getOrderCode());
        orderInfo.setUserId(order.getUserId());
        orderInfo.setUserName(order.getUserName());
        orderInfo.setTotalPrice(order.getTotalPrice());
        orderInfo.setSkuCount(order.getSkuCount());
        orderInfo.setAddressId(order.getAddressId());
        orderInfo.setAddress(order.getAddress());
        orderInfo.setMsg(order.getMsg());
        orderInfo.setState(order.getState());
        orderInfo.setPayTimestamp(order.getPayTimestamp());
        orderInfo.setCreateTimestamp(order.getCreateTimestamp());
        return orderInfo;

    }
}
