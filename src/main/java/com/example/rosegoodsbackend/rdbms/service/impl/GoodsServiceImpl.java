package com.example.rosegoodsbackend.rdbms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.rosegoodsbackend.rdbms.entity.Goods;
import com.example.rosegoodsbackend.rdbms.mapper.GoodsMapper;
import com.example.rosegoodsbackend.rdbms.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

    @Autowired
    private GoodsMapper mapper;

    @Override
    public List<Goods> getAllGoods() {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        return mapper.selectList(queryWrapper);
    }

    @Override
    public List<Goods> searchGoods(String keyword) {
        return null;
    }

    @Override
    public List<Goods> getByCategory(String categoryName) {
        return null;
    }

    @Override
    public List<Goods> getByUser(String username) {
        return null;
    }
}