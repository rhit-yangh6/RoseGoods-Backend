package com.example.rosegoodsbackend.rdbms.controller;

import com.example.rosegoodsbackend.rdbms.common.Result;
import com.example.rosegoodsbackend.rdbms.entity.User;
import com.example.rosegoodsbackend.rdbms.service.IWishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {
    @Autowired
    private IWishlistService wishlistService;

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
        return Result.success(wishlistService.getUserWishlist(user.getUsername()));
    }
}
