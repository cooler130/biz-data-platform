package com.cooler.ai.platform.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TQDataInfo implements Serializable {
    private String id;
    private String tq;
    private String sentence;
    private float belief;

}
