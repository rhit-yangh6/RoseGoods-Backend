package com.example.rosegoodsbackend.rdbms.controller;

import com.example.rosegoodsbackend.rdbms.common.Result;
import com.example.rosegoodsbackend.rdbms.entity.User;
import com.example.rosegoodsbackend.rdbms.entity.UserComments;
import com.example.rosegoodsbackend.rdbms.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @PostMapping(path = "/add")
    Result<Boolean> addComment(User user, @RequestBody UserComments comment){
        if (comment.getGoodsId() <= 0 || comment.getContent().trim().isEmpty()){
            return Result.fail(false);
        }
        comment.setUsername(user.getUsername());
        comment.setCreatedTime(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date()));
        commentService.addComment(comment);
        return Result.success(true);
    }

    @GetMapping(path = "/list")
    List<UserComments> getUserComment(@RequestParam String username){
        return commentService.getUserComments(username);
    }

    @GetMapping(path = "/delete")
    Result<Boolean> deleteComment(User user, @RequestParam int id){
        if (commentService.removeComment(user.getUsername(), id)){
            return Result.success("Successfully deleted comment");
        }
        return Result.fail("Delete comment failed");
    }
}
