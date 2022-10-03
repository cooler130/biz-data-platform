package com.cooler.ai.nlg.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NlgTemplateInfo implements Serializable {
    private Integer sceneId;

    private String dmName;

    private String actionName;

    private String transformIntentName;

    private String intentName;

    private String paramKvs;

    private Byte fixedGuide;

    private Integer nlgId;

    private String topicWord;

    private String themeWord;

    private String nlgTemplate;

    private String extInfo;
}