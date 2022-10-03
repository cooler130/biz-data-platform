package com.cooler.ai.platform.facade;

import com.cooler.ai.platform.model.*;
import org.springframework.stereotype.Component;

import java.util.*;

@Component("buRouterDataFacade")
public class BuRouterDataFacadeImpl implements BuRouterDataFacade {


    @Override
    public List<TQDataInfo> getTqDatas(String sentence) {
        //todo：通过问句，得到带分值的标准问数据
        TQDataInfo tqDataInfo1 = new TQDataInfo("tq-10008", "红包不生效", "我的红包怎么用不了啊？", 0.96f);
        TQDataInfo tqDataInfo2 = new TQDataInfo("tq-10023", "红包怎么使用", "我的红包怎么用不了啊？", 0.83f);
        TQDataInfo tqDataInfo3 = new TQDataInfo("tq-10054", "优惠红包怎么购买", "我的红包怎么用不了啊？", 0.66f);
        return Arrays.asList(tqDataInfo1, tqDataInfo2, tqDataInfo3);
    }

    @Override
    public List<Order2DataInfo> getOrderDatas(String userId, String sentence, TQDataInfo fixedTqDataInfo) {
        //todo：通过多方面数据，得到带分值的订单数据
        Order2DataInfo order2DataInfo1 = new Order2DataInfo("order-10001", "李先生牛肉面套餐", "User-10342", Arrays.asList("你好", "我的红包怎么用不了啊？", "不是"), 0.85f);
        Order2DataInfo order2DataInfo2 = new Order2DataInfo("order-10002", "云南米线套餐", "User-10342", Arrays.asList("你好", "我的红包怎么用不了啊？", "不是"), 0.84f);
        Order2DataInfo order2DataInfo3 = new Order2DataInfo("order-10003", "大董状元餐", "User-10342", Arrays.asList("你好", "我的红包怎么用不了啊？", "不是"), 0.83f);
        return Arrays.asList(order2DataInfo1, order2DataInfo2, order2DataInfo3);
    }

    @Override
    public List<BuDataInfo> getProbableBuDatas(String userId, TQDataInfo fixedTqDataInfo) {
        //todo：根据userId的账户信息，以及 已经确定的标准问 查询 用户最近的订单集，进而来推几个最可能的业务集。 每一个业务默认赋值0.8f
        BuDataInfo buDataInfo1 = new BuDataInfo("bu-001", "高端餐饮", null, null, 0.83f);
        BuDataInfo buDataInfo2 = new BuDataInfo("bu-009", "外卖", null, null, 0.82f);
        BuDataInfo buDataInfo3 = new BuDataInfo("bu-008", "到店美食", null, null, 0.81f);
        return Arrays.asList(buDataInfo1, buDataInfo2, buDataInfo3);
    }

    @Override
    public List<BuDataInfo> getBuDatas(String sentence, TQDataInfo fixedTqDataInfo, Order2DataInfo fixedOrder2DataInfo, List<BuDataInfo> deletedBuDataInfos) {
        //todo：通过多方面数据，得到带分值的业务数据

        if(sentence.equals("都不是")){
            BuDataInfo buDataInfo1 = new BuDataInfo("bu-001", "高端餐饮", Arrays.asList("你好", "我的红包怎么用不了啊？", "不是"), "order-10003", 0.82f);
            BuDataInfo buDataInfo2 = new BuDataInfo("bu-009", "外卖", Arrays.asList("你好", "我的红包怎么用不了啊？", "不是"), "order-10003", 0.65f);
            BuDataInfo buDataInfo3 = new BuDataInfo("bu-008", "到店美食", Arrays.asList("你好", "我的红包怎么用不了啊？", "不是"), "order-10003", 0.36f);
            BuDataInfo buDataInfo4 = new BuDataInfo("bu-022", "vip餐饮", Arrays.asList("你好", "我的红包怎么用不了啊？", "不是"), "order-10006", 0.82f);
            BuDataInfo buDataInfo5 = new BuDataInfo("bu-038", "电影", Arrays.asList("你好", "我的红包怎么用不了啊？", "不是"), "order-10065", 0.85f);
            BuDataInfo buDataInfo6 = new BuDataInfo("bu-018", "单车", Arrays.asList("你好", "我的红包怎么用不了啊？", "不是"), "order-10013", 0.60f);
            List<BuDataInfo> buDataInfos = new ArrayList<>(Arrays.asList(buDataInfo1, buDataInfo2, buDataInfo3, buDataInfo4, buDataInfo5, buDataInfo6));
            buDataInfos.removeAll(deletedBuDataInfos);            //去除掉已经问过的业务集合
            return buDataInfos;
        }else if(sentence.equals("电影")){
            BuDataInfo buDataInfo = new BuDataInfo("bu-038", "电影", Arrays.asList("你好", "我的红包怎么用不了啊？", "不是", "电影"), "order-10065", 0.99f);
            List<BuDataInfo> buDataInfos = new ArrayList<>(Arrays.asList(buDataInfo));
            buDataInfos.removeAll(deletedBuDataInfos);            //去除掉已经问过的业务集合
            return buDataInfos;
        }
        return new ArrayList<>();
    }
}
