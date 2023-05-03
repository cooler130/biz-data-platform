package com.cooler.biz.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cooler.biz.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}