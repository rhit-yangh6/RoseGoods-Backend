package com.example.rosegoodsbackend.rdbms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.rosegoodsbackend.rdbms.entity.Goods;
import com.example.rosegoodsbackend.rdbms.entity.User;
import com.example.rosegoodsbackend.rdbms.mapper.GoodsMapper;
import com.example.rosegoodsbackend.rdbms.pojos.GoodsPojo;
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
        queryWrapper.orderByDesc("created_time").last("limit 10");
        return mapper.selectList(queryWrapper);
    }

    @Override
    public List<Goods> searchGoods(String keyword) {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", keyword);
        return mapper.selectList(queryWrapper);
    }

    @Override
    public List<Goods> getByCategory(int categoryId) {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category_id", categoryId);
        return mapper.selectList(queryWrapper);
    }

    @Override
    public List<Goods> getByUser(String username) {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return mapper.selectList(queryWrapper);
    }

    @Override
    public void addGoods(Goods goods){
        mapper.insert(goods);
    }

    @Override
    public boolean updateGoods(String username, int goodsId, GoodsPojo info){
        UpdateWrapper<Goods> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", goodsId).eq("username", username);
        Goods selected = mapper.selectOne(updateWrapper);
        if (selected == null){
            return false;
        }
        if (!info.getName().trim().isEmpty()){
            updateWrapper.set("name", info.getName());
        }
        if (!info.getImgUrl().trim().isEmpty()){
            updateWrapper.set("img_url", info.getImgUrl());
        }
        if (!info.getDescription().trim().isEmpty()){
            updateWrapper.set("description", info.getDescription());
        }
        if (info.getPrice() > 0){
            updateWrapper.set("price", info.getPrice());
        }
        updateWrapper.set("category_id", info.getCategoryId());
        mapper.update(selected, updateWrapper);
        return true;
    }

    @Override
    public boolean deleteGoods(int id, String username){
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        Goods good = mapper.selectOne(queryWrapper);
        if (good == null){
            return false;
        } else if (good.getUsername().equals(username)){
            mapper.delete(queryWrapper);
            return true;
        }
        return false;
    }

    @Override
    public Goods getGoodsById(int id) {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        Goods good = mapper.selectOne(queryWrapper);
        return good;
    }

    @Override
    public boolean setGoodsStatus(String username, int goodsId, int status){
        UpdateWrapper<Goods> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", goodsId).eq("username", username);
        Goods selected = mapper.selectOne(updateWrapper);
        if (selected == null){
            return false;
        }
        updateWrapper.set("status", status);
        mapper.update(selected, updateWrapper);
        return true;
    }
}
