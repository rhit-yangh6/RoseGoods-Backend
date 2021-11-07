package com.example.rosegoodsbackend.rdbms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("UserComments")
public class UserComments {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String username;

    @TableField(value = "goods_id")
    private int goodsId;

    private String content;

    @TableField(value = "created_time")
    private String createdTime;
}
