package com.example.rosegoodsbackend.rdbms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.rosegoodsbackend.rdbms.entity.UserWishlist;

import java.util.List;

public interface IWishlistService extends IService<UserWishlist>
{
    public void addToWishlist(String username, int itemId);

    public List<UserWishlist> getUserWishlist(String username);

    public boolean removeFromWishlist(String username, int itemId);
}
