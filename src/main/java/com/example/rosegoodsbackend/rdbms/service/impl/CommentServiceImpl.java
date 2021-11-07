package com.example.rosegoodsbackend.rdbms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.rosegoodsbackend.rdbms.entity.UserComments;
import com.example.rosegoodsbackend.rdbms.entity.UserWishlist;
import com.example.rosegoodsbackend.rdbms.mapper.CommentMapper;
import com.example.rosegoodsbackend.rdbms.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, UserComments> implements ICommentService {
    @Autowired
    private CommentMapper mapper;

    @Override
    public void addComment(UserComments comment) {
        mapper.insert(comment);
    }

    @Override
    public List<UserComments> getUserComments(String username) {
        QueryWrapper<UserComments> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return mapper.selectList(queryWrapper);
    }

    @Override
    public boolean removeComment(String username, int id) {
        QueryWrapper<UserComments> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        UserComments comment = mapper.selectOne(queryWrapper);
        if (comment == null || !username.equals(comment.getUsername())){
            return false;
        } else{
            mapper.delete(queryWrapper);
            return true;
        }
    }
}
