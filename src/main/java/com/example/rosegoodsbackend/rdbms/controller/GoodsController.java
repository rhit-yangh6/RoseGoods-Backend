package com.example.rosegoodsbackend.rdbms.controller;

import com.example.rosegoodsbackend.rdbms.common.Result;
import com.example.rosegoodsbackend.rdbms.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;

    @GetMapping(path = "/getGoods")
    public @ResponseBody
    Result<?> getGoods(){
        return Result.success(goodsService.getAllGoods());
    }

    @GetMapping(path = "/searchGoods")
    public @ResponseBody
    Result<?> getGoodsByName(@RequestParam String keyword){
        return Result.success(goodsService.searchGoods(keyword));
    }

    @GetMapping(path = "/searchGoodsByCategory")
    public @ResponseBody
    Result<?> getGoodsByCategory(@RequestParam String category){
        return Result.success(goodsService.getByCategory(category));
    }

    @GetMapping(path = "/userGoods")
    public @ResponseBody
    Result<?> getGoodsByUser(@RequestParam String user){
        return Result.success(goodsService.getByUser(user));
    }
}
