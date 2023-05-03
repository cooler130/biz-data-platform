package com.cooler.ai.burouter;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class BuDataInfo implements Serializable {
    private String id;
    private String bu;

    private List<String> sentences;
    private String orderId;
    private float belief;

    public BuDataInfo(String id, String bu, List<String> sentences, String orderId, float belief) {
        this.id = id;
        this.bu = bu;
        this.sentences = sentences;
        this.orderId = orderId;
        this.belief = belief;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuDataInfo that = (BuDataInfo) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(bu, that.bu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bu);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBu() {
        return bu;
    }

    public void setBu(String bu) {
        this.bu = bu;
    }

    public List<String> getSentences() {
        return sentences;
    }

    public void setSentences(List<String> sentences) {
        this.sentences = sentences;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public float getBelief() {
        return belief;
    }

    public void setBelief(float belief) {
        this.belief = belief;
    }
}
