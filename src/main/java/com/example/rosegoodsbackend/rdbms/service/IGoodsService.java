package com.example.rosegoodsbackend.rdbms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.rosegoodsbackend.rdbms.entity.Goods;
import com.example.rosegoodsbackend.rdbms.pojos.GoodsPojo;

import java.util.List;

public interface IGoodsService extends IService<Goods> {

    List<Goods> getAllGoods();
    List<Goods> searchGoods(String keyword);
    List<Goods> getByCategory(int categoryId);
    List<Goods> getByUser(String username);

    void addGoods(Goods goods);
    boolean updateGoods(String username, int goodsId, GoodsPojo info);
    boolean deleteGoods(int id, String username);
    Goods getGoodsById(int id);
    boolean setGoodsStatus(String username, int goodsId, int status);
}
