package com.cooler.ai.nlg.service.impl;

import com.cooler.ai.nlg.dao.GuideOptionMapper;
import com.cooler.ai.nlg.entity.GuideOption;
import com.cooler.ai.nlg.entity.GuideOptionInfo;
import com.cooler.ai.nlg.service.GuideOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("guideOptionService")
public class GuideOptionServiceImpl implements GuideOptionService {

    @Autowired
    private GuideOptionMapper guideOptionMapper;

    @Override
    public List<GuideOptionInfo> getGuideOptions(Integer nlgId) {
        List<GuideOption> guideOptions = guideOptionMapper.getGuideOptions(nlgId);
        return convert(guideOptions);
    }

    private List<GuideOptionInfo> convert(List<GuideOption> guideOptions){
        List<GuideOptionInfo> guideOptionInfos = new ArrayList<>();
        if(guideOptions == null || guideOptions.size() == 0) return guideOptionInfos;

        for (GuideOption guideOption : guideOptions) {
            GuideOptionInfo guideOptionInfo = new GuideOptionInfo();
            guideOptionInfo.setId(guideOption.getId());
            guideOptionInfo.setNlgId(guideOption.getNlgId());
            guideOptionInfo.setOptionNum(guideOption.getOptionNum());
            guideOptionInfo.setOptionSentence(guideOption.getOptionSentence());
            guideOptionInfo.setOptionExtInfo(guideOption.getOptionExtInfo());
            guideOptionInfo.setDomainName(guideOption.getDomainName());
            guideOptionInfo.setTaskName(guideOption.getTaskName());
            guideOptionInfo.setIntentName(guideOption.getIntentName());
            guideOptionInfo.setSlotKvs(guideOption.getSlotKvs());
            guideOptionInfo.setEnable(guideOption.getEnable());
            guideOptionInfo.setMsg(guideOption.getMsg());
            guideOptionInfos.add(guideOptionInfo);
        }
        return guideOptionInfos;
    }
}
