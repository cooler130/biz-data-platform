package com.cooler.ai.platform.service.impl;

import com.cooler.ai.platform.dao.PoiMapper;
import com.cooler.ai.platform.entity.Poi;
import com.cooler.ai.burouter.PoiInfo;
import com.cooler.ai.platform.service.PoiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhangsheng
 * @Description
 * @Date 2019/9/30
 **/
@Service("poiService")
public class PoiServiceImpl implements PoiService {

    @Resource
    private PoiMapper poiMapper;

    @Override
    public PoiInfo selectPoiById(Integer poiId) {
        Poi poi = poiMapper.selectPoiById(poiId);
        return poi != null ? convertPoiInfo(poi) : null;
    }

    @Override
    public List<PoiInfo> selectPois(String poiName, String brand, int startId, int count, String orderBy, String sort) {
        List<Poi> pois = poiMapper.selectPois(poiName, brand, startId, count, orderBy, sort);
        List<PoiInfo> poiInfos = new ArrayList<>();
        for (Poi poi : pois) {
            PoiInfo poiInfo = convertPoiInfo(poi);
            poiInfos.add(poiInfo);
        }
        return poiInfos;
    }

    private PoiInfo convertPoiInfo(Poi poi){
        if(poi != null){
            PoiInfo poiInfo = new PoiInfo(
                    poi.getId(),
                    poi.getPoiName(),
                    poi.getBrand(),
                    poi.getAvgPrice(),
                    poi.getMsg()
            );
            return poiInfo;
        }
        return null;
    }
}
