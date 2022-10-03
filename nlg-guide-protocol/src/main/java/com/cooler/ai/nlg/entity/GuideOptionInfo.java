package com.cooler.ai.nlg.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuideOptionInfo implements Serializable {
    private Integer id;

    private Integer nlgId;

    private Byte optionNum;

    private String optionSentence;

    private String optionExtInfo;

    private String domainName;

    private String taskName;

    private String intentName;

    private String slotKvs;

    private Byte enable;

    private String msg;

}
