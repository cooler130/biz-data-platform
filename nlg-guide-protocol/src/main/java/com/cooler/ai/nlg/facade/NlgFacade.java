package com.cooler.ai.nlg.facade;

import com.cooler.ai.nlg.entity.GuideOptionInfo;
import com.cooler.ai.nlg.entity.NlgGuidesInfo;
import com.cooler.ai.nlg.entity.NlgTemplateInfo;

import java.util.List;
import java.util.Map;

/**
 * @Author zhangsheng
 * @Description
 * @Date 2019/12/12
 **/

public interface NlgFacade {

    /**
     * 获取Nlg话术（返回对象中包含Nlg模板填上值后的具体字符串）
     * @param dmName
     * @param actionName
     * @param transformIntentName
     * @param intentName
     * @param paramMap
     * @param themeWord
     * @return
     */
    NlgTemplateInfo getNlgSentence(String dmName, String actionName, String transformIntentName, String intentName, Map<String, String> paramMap, String themeWord);

    /**
     * 根据nlgId，获取此话术的多个引导项
     * @param nlgId
     * @return
     */
    List<GuideOptionInfo> getGuideOptions(Integer nlgId);

    /**
     * 将上面的两个函数放到一起，获取话术以及获取引导选项
     * @param dmName
     * @param actionName
     * @param transformIntentName
     * @param intentName
     * @param paramMap
     * @param themeWord
     * @return
     */
    NlgGuidesInfo getNlgGuidesInfo(String dmName, String actionName, String transformIntentName, String intentName, Map<String, String> paramMap, String themeWord);
}
