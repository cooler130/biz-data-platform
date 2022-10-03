package com.cooler.ai.platform.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class PoiInfo implements Serializable {
    private Integer id;

    private String poiName;

    private String brand;

    private float avgPrice;

    private String msg;

}