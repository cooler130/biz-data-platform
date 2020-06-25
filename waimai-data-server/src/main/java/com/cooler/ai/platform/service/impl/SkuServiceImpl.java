package com.cooler.ai.platform.service.impl;

import com.cooler.ai.platform.dao.SkuMapper;
import com.cooler.ai.platform.entity.Sku;
import com.cooler.ai.platform.model.SkuInfo;
import com.cooler.ai.platform.service.SkuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Author zhangsheng
 * @Description
 * @Date 2019/9/30
 **/
@Service("skuService")
public class SkuServiceImpl implements SkuService {
    @Resource
    private SkuMapper skuMapper;

    @Override
    public List<Integer> selectSkuIds(String skuName, Float moreThanPrice, Float lessThanPrice, Integer poiId, String orderBy, String sort) {
        List<Integer> skuIds = skuMapper.selectSkuIds(skuName, moreThanPrice, lessThanPrice, poiId, orderBy, sort);

        return skuIds;
    }

    @Override
    public List<SkuInfo> selectSkus(String skuName, Float moreThanPrice, Float lessThanPrice, Integer poiId, String orderBy, String sort, Integer startId, Integer count) {
        List<Sku> skus = skuMapper.selectSkus(skuName, moreThanPrice, lessThanPrice, poiId, orderBy, sort, startId, count);
        List<SkuInfo> skuInfos = new ArrayList<>();
        for (Sku sku : skus) {
            SkuInfo skuInfo = convertSkuInfo(sku);
            skuInfos.add(skuInfo);
        }
        return skuInfos;
    }

    @Override
    public List<SkuInfo> getSkusByIds(Set<Integer> skuIds) {
        List<Sku> skus = skuMapper.getSkusByIds(skuIds);
        List<SkuInfo> skuInfos = new ArrayList<>();
        for (Sku sku : skus) {
            SkuInfo skuInfo = convertSkuInfo(sku);
            skuInfos.add(skuInfo);
        }
        return skuInfos;
    }

    private SkuInfo convertSkuInfo(Sku sku){
        if(sku != null){
            SkuInfo skuInfo = new SkuInfo(
                    sku.getId(),
                    sku.getSkuName(),
                    sku.getPrice(),
                    sku.getPoiId(),
                    sku.getMsg()
            );
            return skuInfo;
        }
        return null;
    }

}
