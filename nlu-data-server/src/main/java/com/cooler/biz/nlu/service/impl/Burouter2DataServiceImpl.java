package com.cooler.biz.nlu.service.impl;

import com.cooler.ai.burouter.BuDataInfo;
import com.cooler.ai.burouter.OrderDataInfo;
import com.cooler.ai.burouter.TQDataInfo;
import com.cooler.biz.nlu.service.Burouter2DataService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Burouter2DataServiceImpl implements Burouter2DataService {

    TQDataInfo tqDataInfo1 = new TQDataInfo("tq-0001", "红包不生效", "我的红包怎么用不了啊？", 0.96f);
    TQDataInfo tqDataInfo2 = new TQDataInfo("tq-0002", "红包怎么使用", "我的红包怎么用不了啊？", 0.83f);
    TQDataInfo tqDataInfo3 = new TQDataInfo("tq-0003", "优惠红包怎么购买", "我的红包怎么用不了啊？", 0.66f);
    List<TQDataInfo> tqDataInfos =  Arrays.asList(tqDataInfo1, tqDataInfo2, tqDataInfo3);

    OrderDataInfo orderDataInfo1 = new OrderDataInfo("order-10001", "李先生牛肉面套餐", "User-10342", 0.85f);
    OrderDataInfo orderDataInfo2 = new OrderDataInfo("order-10002", "云南米线套餐", "User-10342", 0.84f);
    OrderDataInfo orderDataInfo3 = new OrderDataInfo( "order-10003","大董状元餐", "User-10342", 0.83f);
    List<OrderDataInfo> orderDataInfos = Arrays.asList(orderDataInfo1, orderDataInfo2, orderDataInfo3);

    BuDataInfo buDataInfo1 = new BuDataInfo("bu-001", "高端餐饮",  0.82f);
    BuDataInfo buDataInfo2 = new BuDataInfo("bu-009", "外卖",  0.65f);
    BuDataInfo buDataInfo3 = new BuDataInfo("bu-008", "到店美食",  0.36f);
    BuDataInfo buDataInfo4 = new BuDataInfo("bu-022", "vip餐饮",  0.82f);
    BuDataInfo buDataInfo5 = new BuDataInfo("bu-038", "电影", 0.85f);
    BuDataInfo buDataInfo6 = new BuDataInfo("bu-018", "单车",  0.60f);
    List<BuDataInfo> buDataInfos = new ArrayList<>(Arrays.asList(buDataInfo1, buDataInfo2, buDataInfo3, buDataInfo4, buDataInfo5, buDataInfo6));

    Map<String, Integer> tqIdAboutOrderMap = new HashMap<String, Integer>(){{
       put("tq-0001", 1);
       put("tq-0002", 0);
       put("tq-0003", 0);
    }};

    @Override
    public TQDataInfo getTop1TqData(String sentence, Set<String> excludeTqIds) {
        List<TQDataInfo> tqDataInfos = this.tqDataInfos;

        float maxBelief = 0f;
        TQDataInfo maxTQDataInfo = null;
        for (TQDataInfo tqDataInfo : tqDataInfos) {
            String id = tqDataInfo.getId();
            float belief = tqDataInfo.getBelief();
            if(excludeTqIds != null && excludeTqIds.contains(id)) continue;
            if(belief > maxBelief){
                maxBelief = belief;
                maxTQDataInfo = tqDataInfo;
            }
        }
        return maxTQDataInfo;
    }

    @Override
    public OrderDataInfo getTop1OrderData(String userId, String sentence, String fixedTqId, Set<String> excludeOrderIds) {
        List<OrderDataInfo> orderDataInfos = this.orderDataInfos;           //根据userId和sentence来获取待确定订单数据

        float maxBelief = 0f;
        OrderDataInfo maxOrderDataInfo = null;
        for (OrderDataInfo orderDataInfo : orderDataInfos) {
            String id = orderDataInfo.getId();
            float belief = orderDataInfo.getBelief();
            if(excludeOrderIds != null && excludeOrderIds.contains(id)) continue;
            if(belief > maxBelief){
                maxBelief = belief;
                maxOrderDataInfo = orderDataInfo;
            }
        }
        return maxOrderDataInfo;
    }

    @Override
    public List<BuDataInfo> getTop2BuDatas(String sentence, String fixedTqId, String fixedOrderId, Set<String> excludeBuIds) {
        if(fixedOrderId != null || !fixedOrderId.equals(""))                                            //根据确定的order获取唯一业务数据
            return Arrays.asList(new BuDataInfo("bu-001", "高端餐饮（from order）",  1.0f));

        List<BuDataInfo> buDataInfos = this.buDataInfos;                    //根据sentence  获取多个待确定业务数据

        List<BuDataInfo> buDataInfosFilter = new ArrayList<>();
        for (BuDataInfo buDataInfo : buDataInfos) {
            String id = buDataInfo.getId();
            if(excludeBuIds != null && excludeBuIds.contains(id)){
                buDataInfosFilter.add(buDataInfo);
            }
            if(buDataInfosFilter.size() >= 3) break;
        }
        Collections.sort(buDataInfosFilter, new Comparator<BuDataInfo>() {
            @Override
            public int compare(BuDataInfo o1, BuDataInfo o2) {
                if(o1.getBelief() > o2.getBelief()) return 1;
                else if(o1.getBelief() < o2.getBelief()) return -1;
                return 0;
            }
        });
        return buDataInfosFilter;
    }

    @Override
    public Integer isAboutOrder(String tqId) {
        return tqIdAboutOrderMap.get(tqId);
    }
}
