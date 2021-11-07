package com.example.rosegoodsbackend.rdbms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.rosegoodsbackend.rdbms.entity.UserComments;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper extends BaseMapper<UserComments> {
}
