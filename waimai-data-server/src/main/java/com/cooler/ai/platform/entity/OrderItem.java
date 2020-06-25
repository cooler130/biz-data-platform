package com.cooler.ai.platform.entity;

public class OrderItem {
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

    public OrderItem(Integer id, String orderItemCode, Integer orderId, String userId, String userName, Integer skuId, String skuName, Integer poiId, String poiName, Integer count, Float price, Float totalPrice, String msg, Byte enable) {
        this.id = id;
        this.orderItemCode = orderItemCode;
        this.orderId = orderId;
        this.userId = userId;
        this.userName = userName;
        this.skuId = skuId;
        this.skuName = skuName;
        this.poiId = poiId;
        this.poiName = poiName;
        this.count = count;
        this.price = price;
        this.totalPrice = totalPrice;
        this.msg = msg;
        this.enable = enable;
    }

    public OrderItem() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderItemCode() {
        return orderItemCode;
    }

    public void setOrderItemCode(String orderItemCode) {
        this.orderItemCode = orderItemCode == null ? null : orderItemCode.trim();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName == null ? null : skuName.trim();
    }

    public Integer getPoiId() {
        return poiId;
    }

    public void setPoiId(Integer poiId) {
        this.poiId = poiId;
    }

    public String getPoiName() {
        return poiName;
    }

    public void setPoiName(String poiName) {
        this.poiName = poiName == null ? null : poiName.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public Byte getEnable() {
        return enable;
    }

    public void setEnable(Byte enable) {
        this.enable = enable;
    }
}