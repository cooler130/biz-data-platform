package com.cooler.biz.auth.annotation.resolver;

import com.cooler.biz.auth.annotation.Auth;
import com.cooler.biz.auth.enums.TokenSubject;
import com.cooler.biz.auth.exception.AuthException;
import com.cooler.biz.auth.exception.TokenException;
import com.cooler.biz.auth.exception.UnauthorizedException;
import com.cooler.biz.auth.service.TokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class AuthMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private TokenService tokenService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // @Auth注解默认的参数类型为Long，请根据实际需求修改类型
        return parameter.getParameterType().isAssignableFrom(Long.class);
    }

    @Override
    public Long resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        // 从Header取出AccessToken
        String token = webRequest.getHeader("Access-Token");
        // 判断Token是否为空
        if (token != null && token != "") {
            try {
                // 从Token中获取Id并捕获异常
                Jws<Claims> parse = tokenService.parse(TokenSubject.ACCESS, token);
                Claims body = parse.getBody();
                Long id = body.get("id", Long.class);
                return id;
            } catch (TokenException e) {
                // Token失效，抛出认证异常
                throw new AuthException();
            }
        } else if (!parameter.getParameterAnnotation(Auth.class).required()) {
            // Token为空，判断Token是否可以为空
            return null;
        } else {
            // Token不能为空，抛出未登录异常
            throw new UnauthorizedException();
        }
    }

}