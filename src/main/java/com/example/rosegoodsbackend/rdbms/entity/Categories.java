package com.example.rosegoodsbackend.rdbms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("Categories")
public class Categories implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;
}
