package com.cooler.ai.platform.service.impl;

import com.cooler.ai.platform.dao.OrderItemMapper;
import com.cooler.ai.platform.entity.OrderItem;
import com.cooler.ai.platform.model.OrderItemInfo;
import com.cooler.ai.platform.service.OrderItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Author zhangsheng
 * @Description
 * @Date 2019/12/19
 **/
@Service("orderItemService")
public class OrderItemServiceImpl implements OrderItemService {
    @Resource
    private OrderItemMapper orderItemMapper;

    @Override
    public List<OrderItemInfo> getOrderItemsByOrderIds(List<Integer> orderIds) {
        List<OrderItem> orderItems = orderItemMapper.getOrderItemsByOrderIds(orderIds);
        List<OrderItemInfo> orderItemInfos = new ArrayList<>();
        for (OrderItem orderItem : orderItems) {
            OrderItemInfo orderItemInfo = convertOrderItem(orderItem);
            orderItemInfos.add(orderItemInfo);
        }
        return orderItemInfos;
    }

    @Override
    public OrderItemInfo save(OrderItemInfo orderItemInfo) {
        OrderItem orderItem = convertOrderItemInfo(orderItemInfo);
        Integer orderItemId = orderItemMapper.save(orderItem);
        OrderItemInfo orderItemInfoOut = convertOrderItem(orderItem);
        if(orderItemId != null){
            orderItemInfoOut.setId(orderItemId);
            return orderItemInfoOut;
        }
        return null;
    }

    @Override
    public List<OrderItemInfo> getOrderItemsByUserIdOrderIds(String userId, Set<Integer> orderIds) {
        List<OrderItem> orderItems = orderItemMapper.getOrderItemsByUserIdOrderIds(userId, orderIds);
        List<OrderItemInfo> orderItemInfos = new ArrayList<>();
        for (OrderItem orderItem : orderItems) {
            OrderItemInfo orderItemInfo = convertOrderItem(orderItem);
            orderItemInfos.add(orderItemInfo);
        }
        return orderItemInfos;
    }

    private OrderItemInfo convertOrderItem(OrderItem orderItem){
        OrderItemInfo orderItemInfo = new OrderItemInfo();

        orderItemInfo.setId(orderItem.getId());
        orderItemInfo.setOrderItemCode(orderItem.getOrderItemCode());
        orderItemInfo.setOrderId(orderItem.getOrderId());
        orderItemInfo.setUserId(orderItem.getUserId());
        orderItemInfo.setUserName(orderItem.getUserName());
        orderItemInfo.setSkuId(orderItem.getSkuId());
        orderItemInfo.setSkuName(orderItem.getSkuName());
        orderItemInfo.setPoiId(orderItem.getPoiId());
        orderItemInfo.setPoiName(orderItem.getPoiName());
        orderItemInfo.setCount(orderItem.getCount());
        orderItemInfo.setPrice(orderItem.getPrice());
        orderItemInfo.setTotalPrice(orderItem.getTotalPrice());
        orderItemInfo.setMsg(orderItem.getMsg());
        orderItemInfo.setEnable(orderItem.getEnable());
        return orderItemInfo;
    }

    private OrderItem convertOrderItemInfo(OrderItemInfo orderItemInfo){
        OrderItem orderItem = new OrderItem();

        orderItem.setId(orderItemInfo.getId());
        orderItem.setOrderItemCode(orderItemInfo.getOrderItemCode());
        orderItem.setOrderId(orderItemInfo.getOrderId());
        orderItem.setUserId(orderItemInfo.getUserId());
        orderItem.setUserName(orderItemInfo.getUserName());
        orderItem.setSkuId(orderItemInfo.getSkuId());
        orderItem.setSkuName(orderItemInfo.getSkuName());
        orderItem.setPoiId(orderItemInfo.getPoiId());
        orderItem.setPoiName(orderItemInfo.getPoiName());
        orderItem.setCount(orderItemInfo.getCount());
        orderItem.setPrice(orderItemInfo.getPrice());
        orderItem.setTotalPrice(orderItemInfo.getTotalPrice());
        orderItem.setMsg(orderItemInfo.getMsg());
        orderItem.setEnable(orderItemInfo.getEnable());
        return orderItem;
    }
}
