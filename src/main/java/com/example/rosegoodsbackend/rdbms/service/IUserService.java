package com.example.rosegoodsbackend.rdbms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.rosegoodsbackend.rdbms.entity.User;

public interface IUserService extends IService<User> {

    public String getUsernameFromToken(String token);

    public String getNameFromToken(String token);

    public User getUser(String username);

    public User insertUser(String username, String name);

    public boolean modifyAddress(String username, String address);

    public boolean modifyPhone(String username, String phone);

    public boolean modifyName(String username, String actualName);

}
