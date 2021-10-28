package com.example.rosegoodsbackend.rdbms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.rosegoodsbackend.rdbms.entity.Goods;

import java.util.List;

public interface IGoodsService  extends IService<Goods> {

    public List<Goods> getAllGoods();
    public List<Goods> searchGoods(String keyword);
    public List<Goods> getByCategory(String categoryName);
    public List<Goods> getByUser(String username);

    public void addGoods(String itemName, String username, float price, int categoryId, String descrip, String imgUrl);
    public void deleteGoods(int id);
}
