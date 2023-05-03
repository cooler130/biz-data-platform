package com.cooler.biz.user.controller;

import com.cooler.biz.auth.annotation.Auth;
import com.cooler.biz.base.entity.Result;
import com.cooler.biz.user.data.SignInData;
import com.cooler.biz.user.data.SignUpData;
import com.cooler.biz.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 1.登陆接口，这里得到的token，需要保存到以后每一次请求的Header下的Access-Token中，作为Access-Token的值。
     */
    @PostMapping("/signIn")
    public Result signIn(@RequestBody @Validated SignInData data) {
        // 使用SpringValidation校验数据
        return new Result().success(userService.signIn(data));
    }

    /**
     * 2.注册接口
     */
    @PostMapping("/signUp")
    public Result signUp(@RequestBody @Validated SignUpData data) {
        // 使用SpringValidation校验数据
        userService.signUp(data);
        return new Result().success();
    }

    /**
     * 3.根据Id查看单个用户的信息（一个参数用get，多个就要用post了）
     */
    @GetMapping("/getUserId/{userId}")
    public Result getUserId(@PathVariable("userId") long userId) {
        return new Result().success(userService.getById(userId));
    }

    /**
     * 传Name方法（这里@Auth(required = false)，会去验证token，得不到tokenId，但会进入此方法得到name）
     */
    @GetMapping("/getName/{name}")
    public Result getName(@Auth(required = false) Long sId, @PathVariable("name") String name) {
        // 该接口可以不登陆，未登陆时返回的结果为空，登陆时会返回当前登陆用户的Id
        String msg = "test - " + name;
        return new Result().success(msg);
    }

    /**
     * 查看用户列表（如果需要验证，即使没有业务入参，也要放一个tokenId）
     */
    @GetMapping("/list")
    public Result list(@Auth Long sId) {
        // 该接口需要检测用户是否登陆
        return new Result().success(userService.list());
    }

    /**
     * 传User对象（传对象用Post，@Auth(required = false)，会去验证token，得不到tokenId，但会进入此方法得到data）
     * @param sId
     * @param data
     * @return
     */
    @PostMapping("/getUser1")
    public Result getUser1(@Auth(required = false) Long sId, @RequestBody @Validated SignInData data) {
        // 该接口可以不登陆，未登陆时返回的结果为空，登陆时会返回当前登陆用户的Id
        @NotBlank String name = data.getName();
        @NotBlank String password = data.getPassword();
        return new Result().success(name + ", " + password);
    }

    /**
     * 传User对象（传对象用Post，@Auth，会去验证token，如果得不到tokenId，直接抛出无权限异常，不进入此方法）
     * @param sId
     * @param data
     * @return
     */
    @PostMapping("/getUser2")
    public Result getUser2(@Auth Long sId, @RequestBody @Validated SignInData data) {
        // 该接口可以不登陆，未登陆时返回的结果为空，登陆时会返回当前登陆用户的Id
        @NotBlank String name = data.getName();
        @NotBlank String password = data.getPassword();
        return new Result().success(name + ", " + password);
    }



}

/**
 *  @Auth 只能加到参数前面，可以在AuthMethodArgumentResolver类定义参数类型，此项目定义了Long型，每个需要权限访问的方法
 *  可以准备一个Long型参数，可以用来获取token中的id（可以是sessionId），添加@Auth标注即可检测；
 *
 *  @Auth 分3种情况：无@Auth、有@Auth(required = false)、有@Auth(required = true)，required默认为true：
 *      1.无@Auth：就不进入验证函数，不进行token验证；
 *      2.@Auth(required = false)：进入验证函数，但得不到token，tokenId为空，但还是进入请求的方法；
 *      3.@Auth(required = true)或@Auth：进入验证函数，但得不到token，直接返回无权限异常；
 *
 *  @PathVariable 接收Get请求的少量变量，变量加此标注才能进行绑定，参数多了最好用Post了。
 *
 */