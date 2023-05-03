package com.cooler.ai.platform.service;

import com.cooler.ai.burouter.AddressInfo;

import java.util.List;

/**
 * @Author zhangsheng
 * @Description
 * @Date 2019/12/11
 **/

public interface AddressService {
    List<AddressInfo> getAddressesByUserId(String userId);
}
