package com.cooler.ai.nlu;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class DomainInfo implements Serializable {
    private String uuid;                            // 请求ID

    private String nluDomainName;                       // nlu领域
    private String nluIntentName;                       // nlu意图
    private double score;                           // 结果得分

    private Map<Integer, SlotInfo> slots;           // 填槽结果

    private String utterance;                       // 原文
    private String uttSegment;                      // 原文分词
    private String uttPos;                          // 原文词性

    public DomainInfo() {
    }

    public DomainInfo(String nluDomainName, String nluIntentName, double score) {
        this.uuid = "UUID_" + System.currentTimeMillis();
        this.nluDomainName = nluDomainName;
        this.nluIntentName = nluIntentName;
        this.score = score;
    }

    public DomainInfo(String nluDomainName, String nluIntentName, double score, String utterance) {
        this.uuid = "UUID_" + System.currentTimeMillis();
        this.nluDomainName = nluDomainName;
        this.nluIntentName = nluIntentName;
        this.score = score;
        this.utterance = utterance;
    }

}
