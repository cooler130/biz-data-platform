package com.cooler.ai.platform.dao;

import com.cooler.ai.platform.entity.Poi;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PoiMapper {

    List<Poi> selectPois(
            @Param("poiName") String poiName,
            @Param("brand") String brand,
            @Param("startId") int startId,
            @Param("count") int count,
            @Param("orderBy") String orderBy,
            @Param("sort") String sort
    );

    Poi selectPoiById(@Param("poiId") Integer poiId);
}