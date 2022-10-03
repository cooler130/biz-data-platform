package com.cooler.ai.nlg.entity;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NlgGuidesInfo implements Serializable {

    private NlgTemplateInfo nlgTemplateInfo;
    private List<GuideOptionInfo> guideOptionInfos;

}
