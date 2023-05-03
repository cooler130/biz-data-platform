package com.cooler.ai.platform.service;

import com.cooler.ai.burouter.PoiInfo;

import java.util.List;

/**
 * @Author zhangsheng
 * @Description
 * @Date 2019/9/30
 **/

public interface PoiService {

    PoiInfo selectPoiById(Integer poiId);

    List<PoiInfo> selectPois(String poiName, String brand, int startId, int count, String orderBy, String sort);

}
