package com.example.rosegoodsbackend.rdbms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.rosegoodsbackend.rdbms.entity.Goods;

import java.util.List;

public interface IGoodsService extends IService<Goods> {

    public List<Goods> getAllGoods();
    public List<Goods> searchGoods(String keyword);
    public List<Goods> getByCategory(int categoryId);
    public List<Goods> getByUser(String username);

    public void addGoods(Goods goods);
    public boolean deleteGoods(int id, String username);
    public Goods getGoodsById(int id);
}
