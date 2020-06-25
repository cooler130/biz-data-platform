package com.cooler.ai.nlg.facade;

import com.cooler.ai.nlg.entity.GuideOptionInfo;
import com.cooler.ai.nlg.entity.NlgGuidesInfo;
import com.cooler.ai.nlg.entity.NlgTemplateInfo;
import com.cooler.ai.nlg.service.GuideOptionService;
import com.cooler.ai.nlg.service.NlgTemplateService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @Author zhangsheng
 * @Description
 * @Date 2019/9/30
 **/
@Component("nlgFacade")
public class NlgFacadeImpl implements NlgFacade {

    @Resource
    private NlgTemplateService nlgTemplateService;

    @Resource
    private GuideOptionService guideOptionService;

    @Override
    public NlgTemplateInfo getNlgSentence(String dmName, String actionName, String transformIntentName, String intentName, Map<String, String> paramMap, String themeWord) {
        return nlgTemplateService.getNlgSentence(dmName, actionName, transformIntentName, intentName, paramMap, themeWord);
    }

    @Override
    public List<GuideOptionInfo> getGuideOptions(Integer nlgId) {
        return guideOptionService.getGuideOptions(nlgId);
    }

    @Override
    public NlgGuidesInfo getNlgGuidesInfo(String dmName, String actionName, String transformIntentName, String intentName, Map<String, String> paramMap, String themeWord) {
        NlgTemplateInfo nlgSentenceInfo = getNlgSentence(dmName, actionName, transformIntentName, intentName, paramMap, themeWord);
        Integer nlgId = nlgSentenceInfo.getNlgId();
        List<GuideOptionInfo> guideOptionInfos = null;
        if(nlgId == null) {
            guideOptionInfos = new ArrayList<>();
        }else{
            guideOptionInfos = getGuideOptions(nlgId);
        }
        NlgGuidesInfo nlgGuidesInfo = new NlgGuidesInfo(nlgSentenceInfo, guideOptionInfos);
        return nlgGuidesInfo;
    }

}
