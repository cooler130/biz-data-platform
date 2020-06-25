package com.cooler.ai.platform.entity;

public class Poi {
    private Integer id;

    private String poiName;

    private String brand;

    private Float avgPrice;

    private String msg;

    public Poi(Integer id, String poiName, String brand, Float avgPrice, String msg) {
        this.id = id;
        this.poiName = poiName;
        this.brand = brand;
        this.avgPrice = avgPrice;
        this.msg = msg;
    }

    public Poi() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPoiName() {
        return poiName;
    }

    public void setPoiName(String poiName) {
        this.poiName = poiName == null ? null : poiName.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public Float getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(Float avgPrice) {
        this.avgPrice = avgPrice;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }
}