package com.cooler.ai.burouter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDataInfo implements Serializable {
    private String id;
    private String order;
    private String userId;
    private float belief;

}
