package com.cooler.ai.platform.dao;

import com.cooler.ai.platform.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressMapper {

    List<Address> getAddressesByUserId(@Param("userId") String userId);
}