package com.cooler.ai.nlu;

import lombok.Data;
import java.io.Serializable;

@Data
public class SlotInfo implements Serializable{
    private String name;                                // 槽名
    private String value;                               // 槽值
    private float score;                                // 槽位分值

    private String domain;                              // 槽位隶属的领域
    private int valueType = 1;                          // 槽值类型
    private int slotOpe = 1;                            // 槽值操作
    private String originalText;                        // 原文文本

    public SlotInfo(String name, String value, float score, String originalText, String domain) {
        this.name = name;
        this.value = value;
        this.score = score;
        this.originalText = originalText;
        this.domain = domain;
    }
}
