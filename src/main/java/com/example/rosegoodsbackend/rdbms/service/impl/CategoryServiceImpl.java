package com.example.rosegoodsbackend.rdbms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.rosegoodsbackend.rdbms.entity.Categories;
import com.example.rosegoodsbackend.rdbms.mapper.CategoryMapper;
import com.example.rosegoodsbackend.rdbms.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Categories> implements ICategoryService {

    @Autowired
    private CategoryMapper mapper;

    @Override
    public List<Categories> getAllCategories(){
        QueryWrapper<Categories> queryWrapper = new QueryWrapper<>();
        return mapper.selectList(queryWrapper);
    }

    @Override
    public Categories getOneCategory(int id) {
        QueryWrapper<Categories> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        return mapper.selectOne(queryWrapper);
    }


}
