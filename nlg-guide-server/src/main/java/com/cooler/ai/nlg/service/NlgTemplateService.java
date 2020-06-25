package com.cooler.ai.nlg.service;


import com.cooler.ai.nlg.entity.NlgTemplateInfo;

import java.util.Map; /**
 * Created by zhangsheng on 2019/12/13.
 */
public interface NlgTemplateService {

    /**
     * 获取NLG服务的话术
     * @param dmName                指定对话管理模块（哪个bot）
     * @param actionName            指定动作名称
     * @param transformIntentName   指定转义意图名称
     * @param intentName            指定实际意图名称
     * @param paramMap              放置匹配条件键值对集
     * @param themeWord             主题，在某个状态下可以构建多套话术表达
     * @return                      如果没有查到，返回一个new NlgTemplateInfo()对象
     */
    NlgTemplateInfo getNlgSentence(String dmName, String actionName, String transformIntentName, String intentName, Map<String, String> paramMap, String themeWord);



}
