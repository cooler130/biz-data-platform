package com.cooler.ai.nlg.entity;

import java.io.Serializable;

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

    public NlgTemplateInfo(Integer sceneId, String dmName, String actionName, String transformIntentName, String intentName, String paramKvs, Byte fixedGuide, Integer nlgId, String topicWord, String themeWord, String nlgTemplate, String extInfo) {
        this.sceneId = sceneId;
        this.dmName = dmName;
        this.actionName = actionName;
        this.transformIntentName = transformIntentName;
        this.intentName = intentName;
        this.paramKvs = paramKvs;
        this.fixedGuide = fixedGuide;
        this.nlgId = nlgId;
        this.topicWord = topicWord;
        this.themeWord = themeWord;
        this.nlgTemplate = nlgTemplate;
        this.extInfo = extInfo;
    }

    public NlgTemplateInfo() {
        super();
    }

    public Integer getSceneId() {
        return sceneId;
    }

    public void setSceneId(Integer sceneId) {
        this.sceneId = sceneId;
    }

    public String getDmName() {
        return dmName;
    }

    public void setDmName(String dmName) {
        this.dmName = dmName == null ? null : dmName.trim();
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName == null ? null : actionName.trim();
    }

    public String getTransformIntentName() {
        return transformIntentName;
    }

    public void setTransformIntentName(String transformIntentName) {
        this.transformIntentName = transformIntentName == null ? null : transformIntentName.trim();
    }

    public String getIntentName() {
        return intentName;
    }

    public void setIntentName(String intentName) {
        this.intentName = intentName == null ? null : intentName.trim();
    }

    public String getParamKvs() {
        return paramKvs;
    }

    public void setParamKvs(String paramKvs) {
        this.paramKvs = paramKvs == null ? null : paramKvs.trim();
    }

    public Byte getFixedGuide() {
        return fixedGuide;
    }

    public void setFixedGuide(Byte fixedGuide) {
        this.fixedGuide = fixedGuide;
    }

    public Integer getNlgId() {
        return nlgId;
    }

    public void setNlgId(Integer nlgId) {
        this.nlgId = nlgId;
    }

    public String getTopicWord() {
        return topicWord;
    }

    public void setTopicWord(String topicWord) {
        this.topicWord = topicWord == null ? null : topicWord.trim();
    }

    public String getThemeWord() {
        return themeWord;
    }

    public void setThemeWord(String themeWord) {
        this.themeWord = themeWord == null ? null : themeWord.trim();
    }

    public String getNlgTemplate() {
        return nlgTemplate;
    }

    public void setNlgTemplate(String nlgTemplate) {
        this.nlgTemplate = nlgTemplate == null ? null : nlgTemplate.trim();
    }

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo == null ? null : extInfo.trim();
    }
}