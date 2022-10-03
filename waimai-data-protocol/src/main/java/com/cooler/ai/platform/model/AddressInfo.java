package com.cooler.ai.platform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressInfo implements Serializable{
    private Integer id;

    private String userId;

    private String userName;

    private String address;

    private Integer addressNum;

    private String phoneNum;

    private Byte isDefault;

    private Byte enable;

    private String msg;

}