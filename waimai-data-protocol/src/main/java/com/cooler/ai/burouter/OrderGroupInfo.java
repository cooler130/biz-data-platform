package com.cooler.ai.burouter;

import java.io.Serializable;

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

    public OrderGroupInfo(Integer id, String orderCode, String userId, String userName, Float totalPrice, Integer skuCount, Integer addressId, String address, Long createTimestamp, Integer state, Long payTimestamp, String msg) {
        this.id = id;
        this.orderCode = orderCode;
        this.userId = userId;
        this.userName = userName;
        this.totalPrice = totalPrice;
        this.skuCount = skuCount;
        this.addressId = addressId;
        this.address = address;
        this.createTimestamp = createTimestamp;
        this.state = state;
        this.payTimestamp = payTimestamp;
        this.msg = msg;
    }

    public OrderGroupInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getSkuCount() {
        return skuCount;
    }

    public void setSkuCount(Integer skuCount) {
        this.skuCount = skuCount;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Long getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Long createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getPayTimestamp() {
        return payTimestamp;
    }

    public void setPayTimestamp(Long payTimestamp) {
        this.payTimestamp = payTimestamp;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }
}