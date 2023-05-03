package com.cooler.ai.burouter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class BuDataDto implements Serializable {

    @NotBlank
    private String sentence;
    @NotBlank
    private String fixedTqId;
    @NotBlank
    private String fixedOrderId;
    @NotBlank
    private String excludeBuIds;

}
