package com.cooler.ai.nlg.dao;

import com.cooler.ai.nlg.entity.NlgTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NlgTemplateMapper {

    List<NlgTemplate> getNlgSentence(@Param("dmName")String dmName, @Param("actionName")String actionName, @Param("transformIntentName")String transformIntentName, @Param("intentName")String intentName, @Param("topicWord")String topicWord, @Param("themeWord")String themeWord);
}