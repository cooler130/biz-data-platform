package com.cooler.ai.platform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

@Data
@NoArgsConstructor
public class ShoppingCartInfo implements Serializable{

    private String userId;

    private Map<Integer, Map<Integer, SkuInfo>> selectedSkuInfos = new HashMap<>();

    private Map<Integer, PoiInfo> relatedPoiMap = new HashMap<>();

    private SortedMap<Integer, Integer> skuCountMap = new TreeMap<>();

    private Map<Integer, Long> timestampMap = new HashMap<>();

}
