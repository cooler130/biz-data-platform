package com.cooler.ai.burouter;

import java.io.Serializable;
import java.util.List;

public class OrderDataInfo implements Serializable {
    private String id;
    private String order;
    private String userId;

    private List<String> sentences;
    private float belief;

    public OrderDataInfo(String id, String order, String userId, List<String> sentences, float belief) {
        this.id = id;
        this.order = order;
        this.userId = userId;
        this.sentences = sentences;
        this.belief = belief;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getSentences() {
        return sentences;
    }

    public void setSentences(List<String> sentences) {
        this.sentences = sentences;
    }

    public float getBelief() {
        return belief;
    }

    public void setBelief(float belief) {
        this.belief = belief;
    }
}
