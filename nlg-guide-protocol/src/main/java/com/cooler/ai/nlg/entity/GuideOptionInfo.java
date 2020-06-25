package com.cooler.ai.nlg.entity;

import java.io.Serializable;

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

    public GuideOptionInfo(Integer id, Integer nlgId, Byte optionNum, String optionSentence, String optionExtInfo, String domainName, String taskName, String intentName, String slotKvs, Byte enable, String msg) {
        this.id = id;
        this.nlgId = nlgId;
        this.optionNum = optionNum;
        this.optionSentence = optionSentence;
        this.optionExtInfo = optionExtInfo;
        this.domainName = domainName;
        this.taskName = taskName;
        this.intentName = intentName;
        this.slotKvs = slotKvs;
        this.enable = enable;
        this.msg = msg;
    }

    public GuideOptionInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNlgId() {
        return nlgId;
    }

    public void setNlgId(Integer nlgId) {
        this.nlgId = nlgId;
    }

    public Byte getOptionNum() {
        return optionNum;
    }

    public void setOptionNum(Byte optionNum) {
        this.optionNum = optionNum;
    }

    public String getOptionSentence() {
        return optionSentence;
    }

    public void setOptionSentence(String optionSentence) {
        this.optionSentence = optionSentence == null ? null : optionSentence.trim();
    }

    public String getOptionExtInfo() {
        return optionExtInfo;
    }

    public void setOptionExtInfo(String optionExtInfo) {
        this.optionExtInfo = optionExtInfo == null ? null : optionExtInfo.trim();
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName == null ? null : domainName.trim();
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public String getIntentName() {
        return intentName;
    }

    public void setIntentName(String intentName) {
        this.intentName = intentName == null ? null : intentName.trim();
    }

    public String getSlotKvs() {
        return slotKvs;
    }

    public void setSlotKvs(String slotKvs) {
        this.slotKvs = slotKvs == null ? null : slotKvs.trim();
    }

    public Byte getEnable() {
        return enable;
    }

    public void setEnable(Byte enable) {
        this.enable = enable;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }
}
