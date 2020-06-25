package com.cooler.ai.platform.service.impl;

import com.cooler.ai.platform.dao.AddressMapper;
import com.cooler.ai.platform.entity.Address;
import com.cooler.ai.platform.model.AddressInfo;
import com.cooler.ai.platform.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhangsheng
 * @Description
 * @Date 2019/12/11
 **/
@Service("addressService")
public class AddressServiceImpl implements AddressService {
    @Resource
    private AddressMapper addressMapper;

    @Override
    public List<AddressInfo> getAddressesByUserId(String userId) {
        List<Address> addresses = addressMapper.getAddressesByUserId(userId);

        if(addresses != null){
            List<AddressInfo> addressInfos = new ArrayList<>();
            for (Address address : addresses) {
                AddressInfo addressInfo = convertAddress(address);
                addressInfos.add(addressInfo);
            }
            return addressInfos;
        }
        return null;
    }

    private AddressInfo convertAddress(Address address) {
        if(address != null){
            return new AddressInfo(
                address.getId(),
                address.getUserId(),
                address.getUserName(),
                address.getAddress(),
                address.getAddressNum(),
                address.getPhoneNum(),
                address.getIsDefault(),
                address.getEnable(),
                address.getMsg()
            );
        }
        return null;
    }
}
