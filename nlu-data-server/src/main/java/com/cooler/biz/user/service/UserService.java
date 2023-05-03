package com.cooler.biz.user.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cooler.biz.user.data.SignInData;
import com.cooler.biz.user.data.SignUpData;
import com.cooler.biz.user.entity.User;

public interface UserService extends IService<User> {
    JSONObject signIn(SignInData data);
    void signUp(SignUpData data);
}
