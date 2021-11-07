package com.example.rosegoodsbackend.rdbms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.rosegoodsbackend.rdbms.entity.User;
import com.example.rosegoodsbackend.rdbms.pojos.UserInfoPojo;

public interface IUserService extends IService<User> {

    String getUsernameFromToken(String token);

    String getNameFromToken(String token);

    User getUser(String username);

    User insertUser(String username, String name);

    boolean modifyInfo(String username, UserInfoPojo info);

}
