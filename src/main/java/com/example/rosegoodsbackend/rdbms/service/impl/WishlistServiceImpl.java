package com.example.rosegoodsbackend.rdbms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.rosegoodsbackend.rdbms.entity.Goods;
import com.example.rosegoodsbackend.rdbms.entity.UserWishlist;
import com.example.rosegoodsbackend.rdbms.mapper.WishlistMapper;
import com.example.rosegoodsbackend.rdbms.service.IWishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistServiceImpl  extends ServiceImpl<WishlistMapper, UserWishlist> implements IWishlistService {
    @Autowired
    private WishlistMapper mapper;

    @Override
    public void addToWishlist(String username, int itemId){
        UserWishlist wishlist = new UserWishlist();
        wishlist.setUsername(username);
        wishlist.setGoodsId(itemId);
        mapper.insert(wishlist);
    }

    @Override
    public List<UserWishlist> getUserWishlist(String username) {
        QueryWrapper<UserWishlist> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return mapper.selectList(queryWrapper);
    }

    @Override
    public boolean removeFromWishlist(String username, int itemId) {
        QueryWrapper<UserWishlist> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username).eq("goods_id", itemId);
        UserWishlist wishlist = mapper.selectOne(queryWrapper);
        if (wishlist == null){
            return false;
        } else{
            mapper.delete(queryWrapper);
            return true;
        }
    }
}
