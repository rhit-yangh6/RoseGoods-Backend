package com.example.rosegoodsbackend.rdbms.common;

import com.example.rosegoodsbackend.rdbms.entity.User;
import com.example.rosegoodsbackend.rdbms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class UserResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter par){
        return par.getParameterType().equals((User.class));
    }

    @Autowired
    private IUserService userService;

    @Override
    public Object resolveArgument(MethodParameter par, ModelAndViewContainer mavContainer, NativeWebRequest webReq, WebDataBinderFactory bindFac) throws Exception{
        String token = webReq.getHeader("Authorization");
        String username = userService.getUsernameFromToken(token);
        User user = userService.getUser(username);
        if (user == null) {
            String name = userService.getNameFromToken(token);
            return userService.insertUser(username, name);
        }
        return user;
    }

}