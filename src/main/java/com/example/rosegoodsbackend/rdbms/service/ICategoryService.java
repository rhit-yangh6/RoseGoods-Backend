package com.example.rosegoodsbackend.rdbms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.rosegoodsbackend.rdbms.entity.Categories;

import java.util.List;

public interface ICategoryService extends IService<Categories> {
    List<Categories> getAllCategories();
    Categories getOneCategory(int id);
}
