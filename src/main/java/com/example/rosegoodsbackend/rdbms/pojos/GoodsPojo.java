package com.example.rosegoodsbackend.rdbms.pojos;

import lombok.Data;

@Data
public class GoodsPojo {

    private String name;

    private float price;

    private int categoryId;

    private String description;

    private String imgUrl;

}
