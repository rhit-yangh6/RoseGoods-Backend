package com.example.rosegoodsbackend.rdbms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.rosegoodsbackend.rdbms.entity.UserWishlist;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WishlistMapper extends BaseMapper<UserWishlist> {
}
