package com.cooler.ai.platform.model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BuDataInfo implements Serializable {
    private String id;
    private String bu;

    private List<String> sentences;
    private String orderId;
    private float belief;

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
}
