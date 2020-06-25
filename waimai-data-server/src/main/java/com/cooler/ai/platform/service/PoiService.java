package com.cooler.ai.platform.service;

import com.cooler.ai.platform.entity.Poi;
import com.cooler.ai.platform.entity.Sku;
import com.cooler.ai.platform.model.PoiInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author zhangsheng
 * @Description
 * @Date 2019/9/30
 **/

public interface PoiService {

    PoiInfo selectPoiById(Integer poiId);

    List<PoiInfo> selectPois(String poiName, String brand, int startId, int count, String orderBy, String sort);

}
