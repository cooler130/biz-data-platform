package com.cooler.ai.burouter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class OrderDataDto implements Serializable {
    @NotBlank
    private String userId;
    @NotBlank
    private String sentence;
    @NotBlank
    private String fixedTqId;
    @NotBlank
    private String excludeOrderIds;

}
