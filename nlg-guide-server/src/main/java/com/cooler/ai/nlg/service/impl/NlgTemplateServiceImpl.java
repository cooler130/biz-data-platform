package com.cooler.ai.nlg.service.impl;

import com.alibaba.fastjson.JSON;
import com.cooler.ai.nlg.NlgConstant;
import com.cooler.ai.nlg.dao.NlgTemplateMapper;
import com.cooler.ai.nlg.entity.NlgTemplate;
import com.cooler.ai.nlg.entity.NlgTemplateInfo;
import com.cooler.ai.nlg.service.NlgTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author zhangsheng
 * @Description
 * @Date 2019/12/13
 **/
@Service("nlgTemplateService")
public class NlgTemplateServiceImpl implements NlgTemplateService {

    private static final Logger logger = LoggerFactory.getLogger(NlgTemplateServiceImpl.class);

    @Resource
    private NlgTemplateMapper nlgTemplateMapper;

    private static final Pattern templateContainParamsPattern =Pattern.compile("\\$\\{[a-zA-Z0-9\\_\\-]+\\}");          //话术中的变量命名必须限制在 大小写字母、数值、下划线和横线 这几类字符

    @Override
    public NlgTemplateInfo getNlgSentence(String dmName, String actionName, String transformIntentName, String intentName, Map<String, String> paramMap, String themeWord) {

        //0.按照query_index过滤
        if(paramMap == null) paramMap = new HashMap<>();
        String topicWord = paramMap.get(NlgConstant.P_TOPIC_WORD);
        if(topicWord == null) topicWord = NlgConstant.V_DEFAULT_WORD;                                                   //paramMap没有topic_word，则topic_word默认为"default"

        //1.初步筛选，查询符合初步条件的话术模板记录集合
        List<NlgTemplate> nlgTemplates = nlgTemplateMapper.getNlgSentence(dmName, actionName, transformIntentName, intentName, topicWord, themeWord);
        if(nlgTemplates == null || nlgTemplates.size() == 0)
            nlgTemplates = nlgTemplateMapper.getNlgSentence(dmName, actionName, NlgConstant.V_ANY_INTENT, NlgConstant.V_ANY_INTENT, topicWord, themeWord);
        if(nlgTemplates == null || nlgTemplates.size() == 0)
            nlgTemplates = nlgTemplateMapper.getNlgSentence(dmName, actionName, NlgConstant.V_NONE_VALUE, NlgConstant.V_NONE_VALUE, topicWord, themeWord);
        if(nlgTemplates == null || nlgTemplates.size() == 0)    return new NlgTemplateInfo();

        List<NlgTemplate> nlgTemplatesFilter = new ArrayList<>();
        for (NlgTemplate nlgTemplate : nlgTemplates) {
            String topicWordOfTemplate = nlgTemplate.getTopicWord();
            if(topicWordOfTemplate.equals(topicWord)){
                nlgTemplatesFilter.add(nlgTemplate);
            }
        }

        //2.按照paramMap条件集合进行过滤
        NlgTemplate targetNlgTemplate = null;
        A:for (NlgTemplate nlgTemplate : nlgTemplatesFilter) {
            String paramKvs = nlgTemplate.getParamKvs();
            if(!paramKvs.equals(NlgConstant.V_NONE_VALUE)){                                                             //如果此字段无值，则强制赋予"none"
                Map<String, String> nlgParamMap = JSON.parseObject(paramKvs, Map.class);
                if(nlgParamMap != null){
                    B:for (String nlgKey : nlgParamMap.keySet()) {
                        String nlgValue = nlgParamMap.get(nlgKey);
                        String value = paramMap.get(nlgKey);
                        if(!nlgValue.equals(value)){
                            continue A;
                        }
                    }
                    targetNlgTemplate = nlgTemplate;
                    break A;
                }
            }else{
                targetNlgTemplate = nlgTemplate;
            }
        }

        //3.取出记录中的话术模板
        String sentenceTemplate = null;
        if(targetNlgTemplate != null){
            sentenceTemplate = targetNlgTemplate.getNlgTemplate();
        }else{
            return new NlgTemplateInfo();
        }

        //4.填充话术模板中的变量值
        Matcher matcher = templateContainParamsPattern.matcher(sentenceTemplate);
        while (matcher.find()) {
            String item = matcher.group(0);
            String key = item.replace("${", "").replace("}", "");
            String value = paramMap.get(key);
            if(value != null){
                sentenceTemplate = sentenceTemplate.replace(item, value);
            }else{
                logger.warn("注意：此请求没有传递 " + item + " 这个变量的具体值！！！");
            }
        }

        targetNlgTemplate.setNlgTemplate(sentenceTemplate);
        NlgTemplateInfo nlgTemplateInfo = convert(targetNlgTemplate);
        return nlgTemplateInfo;
    }

    /**
     * 转换为输出模式
     * @param nlgTemplate
     * @return
     */
    private NlgTemplateInfo convert(NlgTemplate nlgTemplate){
        if(nlgTemplate == null) return null;
        NlgTemplateInfo nlgTemplateInfo = new NlgTemplateInfo();
        nlgTemplateInfo.setSceneId(nlgTemplate.getSceneId());
        nlgTemplateInfo.setDmName(nlgTemplate.getDmName());
        nlgTemplateInfo.setActionName(nlgTemplate.getActionName());
        nlgTemplateInfo.setTransformIntentName(nlgTemplate.getTransformIntentName());
        nlgTemplateInfo.setIntentName(nlgTemplate.getIntentName());
        nlgTemplateInfo.setParamKvs(nlgTemplate.getParamKvs());
        nlgTemplateInfo.setNlgId(nlgTemplate.getNlgId());
        nlgTemplateInfo.setTopicWord(nlgTemplate.getTopicWord());
        nlgTemplateInfo.setThemeWord(nlgTemplate.getThemeWord());
        nlgTemplateInfo.setNlgTemplate(nlgTemplate.getNlgTemplate());
        nlgTemplateInfo.setFixedGuide(nlgTemplate.getFixedGuide());
        nlgTemplateInfo.setExtInfo(nlgTemplate.getExtInfo());
        return nlgTemplateInfo;
    }

}
