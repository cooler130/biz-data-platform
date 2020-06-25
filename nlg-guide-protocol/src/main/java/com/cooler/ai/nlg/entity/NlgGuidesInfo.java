package com.cooler.ai.nlg.entity;

import java.io.Serializable;
import java.util.List;

public class NlgGuidesInfo implements Serializable {

    private NlgTemplateInfo nlgTemplateInfo;
    private List<GuideOptionInfo> guideOptionInfos;

    public NlgGuidesInfo(NlgTemplateInfo nlgTemplateInfo, List<GuideOptionInfo> guideOptionInfos) {
        this.nlgTemplateInfo = nlgTemplateInfo;
        this.guideOptionInfos = guideOptionInfos;
    }

    public NlgTemplateInfo getNlgTemplateInfo() {
        return nlgTemplateInfo;
    }

    public void setNlgTemplateInfo(NlgTemplateInfo nlgTemplateInfo) {
        this.nlgTemplateInfo = nlgTemplateInfo;
    }

    public List<GuideOptionInfo> getGuideOptionInfos() {
        return guideOptionInfos;
    }

    public void setGuideOptionInfos(List<GuideOptionInfo> guideOptionInfos) {
        this.guideOptionInfos = guideOptionInfos;
    }
}
