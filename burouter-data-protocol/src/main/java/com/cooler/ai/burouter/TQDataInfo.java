package com.cooler.ai.burouter;

import java.io.Serializable;

public class TQDataInfo implements Serializable {
    private String id;
    private String tq;
    private String sentence;
    private float belief;

    public TQDataInfo() {
    }

    public TQDataInfo(String id, String tq, String sentence, float belief) {
        this.id = id;
        this.tq = tq;
        this.sentence = sentence;
        this.belief = belief;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTq() {
        return tq;
    }

    public void setTq(String tq) {
        this.tq = tq;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public float getBelief() {
        return belief;
    }

    public void setBelief(float belief) {
        this.belief = belief;
    }
}
