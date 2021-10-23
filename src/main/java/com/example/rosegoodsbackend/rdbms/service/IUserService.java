package com.example.rosegoodsbackend.rdbms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.rosegoodsbackend.rdbms.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Chet Zhang
 * @since 2021-09-17
 */
public interface IUserService extends IService<User> {

    public String getUsernameFromToken(String token);

    public String getNameFromToken(String token);

    public User getUser(String username);

    public User insertUser(String username, String name);

}
