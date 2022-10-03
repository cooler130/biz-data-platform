package com.cooler.ai.platform.model;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order2DataInfo implements Serializable {
    private String id;
    private String order;
    private String userId;

    private List<String> sentences;
    private float belief;

}
