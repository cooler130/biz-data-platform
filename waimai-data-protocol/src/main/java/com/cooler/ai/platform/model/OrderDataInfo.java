package com.cooler.ai.platform.model;

import java.io.Serializable;
import java.util.List;

/**
 * @Author zhangsheng
 * @Description
 * @Date 2019/12/11
 **/

public class OrderDataInfo implements Serializable{

    private OrderGroupInfo orderGroupInfo;
    private List<OrderItemInfo> orderItemInfos;
    private boolean isRecord = false;

    public OrderDataInfo(OrderGroupInfo orderGroupInfo, List<OrderItemInfo> orderItemInfos, boolean isRecord) {
        this.orderGroupInfo = orderGroupInfo;
        this.orderItemInfos = orderItemInfos;
        this.isRecord = isRecord;
    }

    public boolean isRecord() {
        return isRecord;
    }

    public void setRecord(boolean record) {
        isRecord = record;
    }

    public OrderGroupInfo getOrderGroupInfo() {
        return orderGroupInfo;
    }

    public void setOrderGroupInfo(OrderGroupInfo orderGroupInfo) {
        this.orderGroupInfo = orderGroupInfo;
    }

    public List<OrderItemInfo> getOrderItemInfos() {
        return orderItemInfos;
    }

    public void setOrderItemInfos(List<OrderItemInfo> orderItemInfos) {
        this.orderItemInfos = orderItemInfos;
    }
}
