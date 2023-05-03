package com.cooler.biz.nlu.service.impl;

import com.cooler.ai.nlu.DomainInfo;
import com.cooler.ai.nlu.SlotInfo;
import com.cooler.biz.nlu.service.NLUDataService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("staticDataService")
public class NLUDataServiceImpl implements NLUDataService {

    public static final String NO_DOMAIN = "no_domain";
    public static final String BU_ROUTER2 = "burouter2";
    public static final String BOSS_HIRING = "boss_hiring";

    //--------------------------------------------------------no_domain

    //noDomian领域（公共领域）    domain_intent 数据
    private final Map<String, DomainInfo> noDomianDIMap = new HashMap<String, DomainInfo>() {
        {
            put("不是", new DomainInfo(NO_DOMAIN, "negative", 1.0, "不是"));
            put("都不是", new DomainInfo(NO_DOMAIN, "negative", 1.0, "都不是"));
            put("是的", new DomainInfo(NO_DOMAIN, "positive", 1.0, "是的"));
            put("电影", new DomainInfo(NO_DOMAIN, "express_business", 1.0, "电影"));
            put("第一个", new DomainInfo(NO_DOMAIN, "select", 1.0, "第一个"));
            put("第二个", new DomainInfo(NO_DOMAIN, "select", 1.0, "第二个"));
            put("第三个", new DomainInfo(NO_DOMAIN, "select", 1.0, "第三个"));
            put("转人工", new DomainInfo(NO_DOMAIN, "people_service", 1.0, "转人工"));
        }
    };

    //--------------------------------------------------------burouter

    //burouter领域    domain_intent 数据
    private final Map<String, DomainInfo> burouter2DIMap = new HashMap<String, DomainInfo>() {
        {
            put("我的红包怎么用不了啊？", new DomainInfo(BU_ROUTER2, "express_question", 1.0, "我的红包怎么用不了啊？"));
            put("我说的是我昨天的外卖订单。", new DomainInfo(BU_ROUTER2, "express_order", 1.0, "我说的是我昨天的外卖订单。"));
            put("我的红包呢？", new DomainInfo(BU_ROUTER2, "unknown_intent", 1.0, "我的红包呢？"));
        }
    };

    //burouter领域    slot 数据
    private final Map<String, List<SlotInfo>> burouter2SMap = new HashMap<String, List<SlotInfo>>() {
        {
            put("第一个", Arrays.asList(
                    new SlotInfo("option_num", "1", 1.0f, "第一个", BU_ROUTER2)
            ));
            put("第二个", Arrays.asList(
                    new SlotInfo("option_num", "2", 1.0f, "第二个", BU_ROUTER2)
            ));
            put("第三个", Arrays.asList(
                    new SlotInfo("option_num", "3", 1.0f, "第三个", BU_ROUTER2)
            ));

        }
    };

    //--------------------------------------------------------boss_hiring

    //boss_hiring领域    domain_intent 数据
    private final Map<String, DomainInfo> bossHiringDIMap = new HashMap<String, DomainInfo>() {
        {
            put("好的", new DomainInfo(BOSS_HIRING, "common_reply", 1.0, "好的"));
            put("您好，想跟您交流一下这个岗位。", new DomainInfo(BOSS_HIRING, "request_communicate", 1.0, "您好，想跟您交流一下这个岗位。"));
            put("您好，想看看我能否参加这个岗位的面试。", new DomainInfo(BOSS_HIRING, "request_interview", 1.0, "您好，简历已发，请您查收。"));
            put("您好，简历已发，请您查收。", new DomainInfo(BOSS_HIRING, "give_resume", 1.0, "您好，简历已发，请您查收。"));
            put("谢谢您！", new DomainInfo(BOSS_HIRING, "express_thanks", 1.0, "谢谢您！"));

            put("这是民生银行的岗位吗？", new DomainInfo(BOSS_HIRING, "ask_other_question", 1.0, "这是民生银行的岗位吗？"));
            put("有民生银行的岗位吗？", new DomainInfo(BOSS_HIRING, "ask_other_question", 1.0, "有民生银行的岗位吗？"));

        }
    };


    //总体领域意图数据集
    private final Map<String, Map<String, DomainInfo>> fatherDIMap = new HashMap<String, Map<String, DomainInfo>>() {
        {
            put(NO_DOMAIN, noDomianDIMap);
            put(BU_ROUTER2, burouter2DIMap);
            put(BOSS_HIRING, bossHiringDIMap);
        }
    };

    //总体槽位数据集
    private final Map<String, Map<String, List<SlotInfo>>> fatherSMap = new HashMap<String, Map<String, List<SlotInfo>>>() {
        {
            put(BU_ROUTER2, burouter2SMap);
        }
    };

    @Override
    public Map<String, Map<String, DomainInfo>> getFatherDIMap(){
        return fatherDIMap;
    }

    @Override
    public Map<String, Map<String, List<SlotInfo>>> getFatherSMap(){
        return fatherSMap;
    }

}
