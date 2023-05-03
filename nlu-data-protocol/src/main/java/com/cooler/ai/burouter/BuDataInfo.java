package com.cooler.ai.burouter;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class BuDataInfo implements Serializable {
    private String id;
    private String bu;
    private float belief;

}
