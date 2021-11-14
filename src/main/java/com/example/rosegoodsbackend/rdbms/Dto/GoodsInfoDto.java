package com.example.rosegoodsbackend.rdbms.Dto;

import lombok.Data;

@Data
public class GoodsInfoDto {
    private Integer id;

    private String name;

    private String username;

    private String userAddress;

    private String userPhone;

    private Float price;

    private String createdTime;

    private String categoryName;

    private String description;

    private Integer status;

    private String imgUrl;

    private Integer views;

    private Boolean onWishlist;
}
