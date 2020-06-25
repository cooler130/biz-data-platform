package com.cooler.ai.platform.entity;

public class Sku {
    private Integer id;

    private String skuName;

    private Float price;

    private Integer poiId;

    private String msg;

    public Sku(Integer id, String skuName, Float price, Integer poiId, String msg) {
        this.id = id;
        this.skuName = skuName;
        this.price = price;
        this.poiId = poiId;
        this.msg = msg;
    }

    public Sku() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName == null ? null : skuName.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getPoiId() {
        return poiId;
    }

    public void setPoiId(Integer poiId) {
        this.poiId = poiId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }
}