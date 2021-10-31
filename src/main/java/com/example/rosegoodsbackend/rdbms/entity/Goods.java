package com.example.rosegoodsbackend.rdbms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("Goods")
public class Goods implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private String username;

    private float price;

    @TableField(value = "created_time")
    private String createdTime;

    @TableField(value = "category_id")
    private int categoryId;

    private String description;

    private int status;

    @TableField(value = "img_url")
    private String imgUrl;

    private int views;
}
