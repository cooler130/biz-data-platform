package com.cooler.ai.burouter;

import java.io.Serializable;

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

    public AddressInfo(Integer id, String userId, String userName, String address, Integer addressNum, String phoneNum, Byte isDefault, Byte enable, String msg) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.address = address;
        this.addressNum = addressNum;
        this.phoneNum = phoneNum;
        this.isDefault = isDefault;
        this.enable = enable;
        this.msg = msg;
    }

    public AddressInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getAddressNum() {
        return addressNum;
    }

    public void setAddressNum(Integer addressNum) {
        this.addressNum = addressNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }

    public Byte getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Byte isDefault) {
        this.isDefault = isDefault;
    }

    public Byte getEnable() {
        return enable;
    }

    public void setEnable(Byte enable) {
        this.enable = enable;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }
}