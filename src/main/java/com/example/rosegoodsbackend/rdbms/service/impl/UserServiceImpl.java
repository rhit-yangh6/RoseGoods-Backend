package com.example.rosegoodsbackend.rdbms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.rosegoodsbackend.rdbms.common.AuthData;
import com.example.rosegoodsbackend.rdbms.entity.User;
import com.example.rosegoodsbackend.rdbms.mapper.UserMapper;
import com.example.rosegoodsbackend.rdbms.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jason Qiu
 * @since 2021-09-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public String getUsernameFromToken(String token) {
        AuthData data = new AuthData(Jwts.parser().setSigningKey("MG9BRHIp75bvtGtc8qug".getBytes()).parseClaimsJws(token).getBody());
        return data.getUsername();
    }

    @Override
    public String getNameFromToken(String token) {
        AuthData data = new AuthData(Jwts.parser().setSigningKey("MG9BRHIp75bvtGtc8qug".getBytes()).parseClaimsJws(token).getBody());
        return data.getName();
    }

    @Override
    public User getUser(String username){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return mapper.selectOne(queryWrapper);
    }

    @Override
    public User insertUser(String username, String name) {
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setName(name);
//        newUser.setId();
        mapper.insert(newUser);
        return newUser;
    }

}
