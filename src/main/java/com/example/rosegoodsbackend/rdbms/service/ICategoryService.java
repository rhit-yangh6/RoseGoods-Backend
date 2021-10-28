package com.example.rosegoodsbackend.rdbms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.rosegoodsbackend.rdbms.entity.Categories;
import com.example.rosegoodsbackend.rdbms.entity.Goods;

import java.util.List;

public interface ICategoryService extends IService<Categories> {
    public List<Categories> getAllCategories();

}
