package com.cooler.ai.platform.facade;

import com.cooler.ai.platform.model.*;
import java.util.List;

public interface BuRouterDataFacade {

    /**
     * 通过原始query，获得标准问数据
     * @param sentence
     * @return
     */
    List<TQDataInfo> getTqDatas(String sentence);

    /**
     * 通过userId、原句、已确认的标准问来获取订单
     * @param userId
     * @param sentence
     * @param fixedTqDataInfo
     * @return
     */
    List<Order2DataInfo> getOrderDatas(String userId, String sentence, TQDataInfo fixedTqDataInfo);

    /**
     * 为userId的用户获取初始的默认的业务集合
     * @param userId
     * @param fixedTqDataInfo
     * @return
     */
    List<BuDataInfo> getProbableBuDatas(String userId, TQDataInfo fixedTqDataInfo);

    /**
     * 通过原句、已确认标准问、已确认订单来获取业务
     * @param sentence
     * @param fixedTqDataInfo
     * @param fixedOrder2DataInfo
     * @return
     */
    List<BuDataInfo> getBuDatas(String sentence, TQDataInfo fixedTqDataInfo, Order2DataInfo fixedOrder2DataInfo, List<BuDataInfo> askedBuDataInfos);

}
