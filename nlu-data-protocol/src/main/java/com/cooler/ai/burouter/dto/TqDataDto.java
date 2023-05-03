package com.cooler.ai.burouter.dto;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class TqDataDto implements Serializable {
    @NotBlank
    private String sentence;
    @NotBlank
    private String excludeTqIds;

}
