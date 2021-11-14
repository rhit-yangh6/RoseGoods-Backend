package com.example.rosegoodsbackend.rdbms.Dto;
import lombok.Data;

@Data
public class WishlistGoodDto {
    private Integer id;

    private String username;

    private String name;

    private int goodsId;

    private String imgUrl;

    private int categoryId;
}
