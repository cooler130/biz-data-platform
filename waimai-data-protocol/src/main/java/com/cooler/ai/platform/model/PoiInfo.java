package com.cooler.ai.platform.model;

import java.io.Serializable;

public class PoiInfo implements Serializable {
    private Integer id;

    private String poiName;

    private String brand;

    private float avgPrice;

    private String msg;

    public PoiInfo(Integer id, String poiName, String brand, float avgPrice, String msg) {
        this.id = id;
        this.poiName = poiName;
        this.brand = brand;
        this.avgPrice = avgPrice;
        this.msg = msg;
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
        this.poiName = poiName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(float avgPrice) {
        this.avgPrice = avgPrice;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}