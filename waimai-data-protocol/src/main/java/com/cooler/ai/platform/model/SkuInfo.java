package com.cooler.ai.platform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkuInfo implements Serializable {
    private Integer id;

    private String skuName;

    private Float price;

    private Integer poiId;

    private String msg;

}