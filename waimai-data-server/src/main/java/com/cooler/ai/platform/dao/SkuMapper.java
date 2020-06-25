package com.cooler.ai.platform.dao;

import com.cooler.ai.platform.entity.Sku;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface SkuMapper {

    List<Integer> selectSkuIds(
            @Param("skuName") String skuName,
            @Param("moreThanPrice") Float moreThanPrice,
            @Param("lessThanPrice") Float lessThanPrice,
            @Param("poiId") Integer poiId,
            @Param("orderBy") String orderBy,
            @Param("sort") String sort
    );

    List<Sku> selectSkus(
            @Param("skuName") String skuName,
            @Param("moreThanPrice") Float moreThanPrice,
            @Param("lessThanPrice") Float lessThanPrice,
            @Param("poiId") Integer poiId,
            @Param("orderBy") String orderBy,
            @Param("sort") String sort,
            @Param("startId") Integer startId,
            @Param("count") Integer count
    );

    List<Sku> getSkusByIds(@Param("skuIds") Set<Integer> skuIds);

}