package com.cooler.ai.platform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderGroupInfo implements Serializable {
    private Integer id;

    private String orderCode;

    private String userId;

    private String userName;

    private Float totalPrice;

    private Integer skuCount;

    private Integer addressId;

    private String address;

    private Long createTimestamp;

    private Integer state;

    private Long payTimestamp;

    private String msg;

}