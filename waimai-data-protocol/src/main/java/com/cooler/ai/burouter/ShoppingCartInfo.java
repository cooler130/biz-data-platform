package com.cooler.ai.burouter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @Author zhangsheng
 * @Description
 * @Date 2019/11/28
 **/

public class ShoppingCartInfo implements Serializable{

    private String userId;

    private Map<Integer, Map<Integer, SkuInfo>> selectedSkuInfos = new HashMap<>();

    private Map<Integer, PoiInfo> relatedPoiMap = new HashMap<>();

    private SortedMap<Integer, Integer> skuCountMap = new TreeMap<>();

    private Map<Integer, Long> timestampMap = new HashMap<>();


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Map<Integer, Map<Integer, SkuInfo>> getSelectedSkuInfos() {
        return selectedSkuInfos;
    }

    public void setSelectedSkuInfos(Map<Integer, Map<Integer, SkuInfo>> selectedSkuInfos) {
        this.selectedSkuInfos = selectedSkuInfos;
    }

    public Map<Integer, PoiInfo> getRelatedPoiMap() {
        return relatedPoiMap;
    }

    public void setRelatedPoiMap(Map<Integer, PoiInfo> relatedPoiMap) {
        this.relatedPoiMap = relatedPoiMap;
    }

    public SortedMap<Integer, Integer> getSkuCountMap() {
        return skuCountMap;
    }

    public void setSkuCountMap(SortedMap<Integer, Integer> skuCountMap) {
        this.skuCountMap = skuCountMap;
    }

    public Map<Integer, Long> getTimestampMap() {
        return timestampMap;
    }

    public void setTimestampMap(Map<Integer, Long> timestampMap) {
        this.timestampMap = timestampMap;
    }
}
