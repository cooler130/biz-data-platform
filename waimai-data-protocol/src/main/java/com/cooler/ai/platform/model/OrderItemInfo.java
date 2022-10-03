package com.cooler.ai.platform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemInfo implements Serializable{
    private Integer id;

    private String orderItemCode;

    private Integer orderId;

    private String userId;

    private String userName;

    private Integer skuId;

    private String skuName;

    private Integer poiId;

    private String poiName;

    private Integer count;

    private Float price;

    private Float totalPrice;

    private String msg;

    private Byte enable;

}