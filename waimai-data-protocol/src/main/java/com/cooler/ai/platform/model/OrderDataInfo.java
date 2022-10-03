package com.cooler.ai.platform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDataInfo implements Serializable{

    private OrderGroupInfo orderGroupInfo;
    private List<OrderItemInfo> orderItemInfos;
    private boolean isRecord = false;

}
