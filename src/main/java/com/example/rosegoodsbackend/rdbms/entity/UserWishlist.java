package com.example.rosegoodsbackend.rdbms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("UserWishlist")
public class UserWishlist implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String username;

    @TableField(value = "goods_id")
    private int goodsId;
}
