package com.example.rosegoodsbackend.rdbms.pojos;

import lombok.Data;

@Data
public class GoodsPojo {

    private String name;

    private Float price;

    private Integer categoryId;

    private String description;

    private String imgUrl;

}
