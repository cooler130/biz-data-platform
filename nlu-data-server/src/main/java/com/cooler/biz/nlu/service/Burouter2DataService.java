package com.cooler.biz.nlu.service;

import com.cooler.ai.burouter.BuDataInfo;
import com.cooler.ai.burouter.OrderDataInfo;
import com.cooler.ai.burouter.TQDataInfo;

import java.util.*;


public interface Burouter2DataService {


    TQDataInfo getTop1TqData(String sentence, Set<String> excludeTqIds);


    OrderDataInfo getTop1OrderData(String userId, String sentence, String fixedTqId, Set<String> excludeOrderIds);


    List<BuDataInfo> getTop2BuDatas(String sentence, String fixedTqId, String fixedOrderId, Set<String> excludeBuIds);

    Integer isAboutOrder(String tqId);

}
