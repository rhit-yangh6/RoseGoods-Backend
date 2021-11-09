package com.example.rosegoodsbackend.rdbms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.rosegoodsbackend.rdbms.entity.UserComments;

import java.util.List;

public interface ICommentService extends IService<UserComments> {
    void addComment(UserComments comment);

    List<UserComments> getUserComments(String username);

    boolean removeComment(String username, int id);

    List<UserComments> getGoodsComments(int goodsId);
}
