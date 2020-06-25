package com.cooler.ai.nlg.service;

import com.cooler.ai.nlg.entity.GuideOptionInfo;

import java.util.List;

public interface GuideOptionService {

    /**
     * 根据nlgId查询引导项，如果没有查询到，返回一个空的ArrayList集合
     * @param nlgId
     * @return
     */
    List<GuideOptionInfo> getGuideOptions(Integer nlgId);

}
