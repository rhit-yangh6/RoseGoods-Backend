package com.example.rosegoodsbackend.rdbms.controller;

import com.example.rosegoodsbackend.rdbms.common.Result;
import com.example.rosegoodsbackend.rdbms.entity.User;
import com.example.rosegoodsbackend.rdbms.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;

    @GetMapping(path = "/all")
    public @ResponseBody
    Result<?> getGoods(){
        return Result.success(goodsService.getAllGoods());
    }

    @GetMapping(path = "/search")
    public @ResponseBody
    Result<?> getGoodsByName(@RequestParam String keyword){
        return Result.success(goodsService.searchGoods(keyword));
    }

    @GetMapping(path = "/category")
    public @ResponseBody
    Result<?> getGoodsByCategory(@RequestParam int category){
        return Result.success(goodsService.getByCategory(category));
    }

    @GetMapping(path = "/user")
    public @ResponseBody
    Result<?> getGoodsByUser(@RequestParam String username){
        return Result.success(goodsService.getByUser(username));
    }

    @GetMapping(path = "/delete")
    public @ResponseBody
    Result<Boolean> deleteGoods(User user, @RequestParam Integer id){
        boolean deleted = goodsService.deleteGoods(id, user.getUsername());
        if (deleted) {
            return Result.success("Successfully deleted the item");
        } else {
            return Result.fail("Cannot delete the item");
        }
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    Result<Boolean> addGoods(User user, @RequestParam String itemName, @RequestParam float price, @RequestParam int categoryId, @RequestParam String descrip, @RequestParam String imgUrl){
        goodsService.addGoods(itemName, user.getUsername(), price, categoryId, descrip, imgUrl);
        return Result.success(true);
    }
}
