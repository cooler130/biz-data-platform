package com.cooler.ai.burouter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TQDataInfo implements Serializable {
    private String id;
    private String tq;
    private String sentence;
    private float belief;
}
