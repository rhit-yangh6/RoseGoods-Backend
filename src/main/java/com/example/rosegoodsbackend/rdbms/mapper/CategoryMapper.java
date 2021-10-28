package com.example.rosegoodsbackend.rdbms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.rosegoodsbackend.rdbms.entity.Categories;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper  extends BaseMapper<Categories> {
}
