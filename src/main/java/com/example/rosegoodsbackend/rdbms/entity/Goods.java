package com.example.rosegoodsbackend.rdbms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("Goods")
public class Goods {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private String username;

    private float price;

    private String created_time;

    private int category_id;

    private String description;

    private int status;

    private String img_url;
}
