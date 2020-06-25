package com.cooler.ai.platform.service;

import com.cooler.ai.platform.model.SkuInfo;
import java.util.List;
import java.util.Set;

/**
 * @Author zhangsheng
 * @Description
 * @Date 2019/9/30
 **/

public interface SkuService {

    List<Integer> selectSkuIds(
            String skuName,
            Float moreThanPrice,
            Float lessThanPrice,
            Integer poiId,
            String orderBy,
            String sort
    );

    List<SkuInfo> selectSkus(
            String skuName,
            Float moreThanPrice,
            Float lessThanPrice,
            Integer poiId,
            String orderBy,
            String sort,
            Integer startId,
            Integer count
    );

    List<SkuInfo> getSkusByIds(Set<Integer> skuIds);
}
