package com.example.rosegoodsbackend.rdbms.controller;

import com.example.rosegoodsbackend.rdbms.Dto.WishlistGoodDto;
import com.example.rosegoodsbackend.rdbms.common.Result;
import com.example.rosegoodsbackend.rdbms.entity.Goods;
import com.example.rosegoodsbackend.rdbms.entity.User;
import com.example.rosegoodsbackend.rdbms.entity.UserWishlist;
import com.example.rosegoodsbackend.rdbms.service.IGoodsService;
import com.example.rosegoodsbackend.rdbms.service.IWishlistService;
import com.example.rosegoodsbackend.rdbms.service.impl.WishlistServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {
    @Autowired
    private IWishlistService wishlistService;

    @Autowired
    private IGoodsService goodsService;

    @GetMapping(path = "/add")
    public @ResponseBody
    Result<Boolean> addToList(User user, @RequestParam int itemId){
        wishlistService.addToWishlist(user.getUsername(), itemId);
        return Result.success(true);
    }

    @GetMapping(path = "/delete")
    public @ResponseBody
    Result<Boolean> deleteFromList(User user, @RequestParam int itemId){
        if (wishlistService.removeFromWishlist(user.getUsername(), itemId)){
            return Result.success("Successfully deleted from wishlist");
        }
        return Result.fail("Delete from wishlist failed");
    }

    @GetMapping(path = "/list")
    public @ResponseBody
    Result<?> viewWishlist(User user){
        List<UserWishlist> list = wishlistService.getUserWishlist(user.getUsername());
        List<WishlistGoodDto> returnList = new ArrayList<>();
        for (UserWishlist wish : list) {
            WishlistGoodDto wishlistGoodDto = new WishlistGoodDto();
            BeanUtils.copyProperties(wish, wishlistGoodDto);
            Goods goods = goodsService.getGoodsById(wish.getGoodsId());
            BeanUtils.copyProperties(goods, wishlistGoodDto);
            returnList.add(wishlistGoodDto);
        }
        return Result.success(returnList);
    }
}
