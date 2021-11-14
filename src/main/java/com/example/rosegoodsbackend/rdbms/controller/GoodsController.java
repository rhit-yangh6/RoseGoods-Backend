package com.example.rosegoodsbackend.rdbms.controller;

import com.example.rosegoodsbackend.rdbms.Dto.GoodsInfoDto;
import com.example.rosegoodsbackend.rdbms.common.Result;
import com.example.rosegoodsbackend.rdbms.entity.Categories;
import com.example.rosegoodsbackend.rdbms.entity.Goods;
import com.example.rosegoodsbackend.rdbms.entity.User;
import com.example.rosegoodsbackend.rdbms.pojos.GoodsPojo;
import com.example.rosegoodsbackend.rdbms.service.ICategoryService;
import com.example.rosegoodsbackend.rdbms.service.IGoodsService;
import com.example.rosegoodsbackend.rdbms.service.IUserService;
import com.example.rosegoodsbackend.rdbms.service.IWishlistService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IWishlistService wishlistService;

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
    Result<Boolean> addGoods(User user, @RequestBody GoodsPojo goodsPojo){
        Goods goods = new Goods();

        BeanUtils.copyProperties(goodsPojo, goods);
        goods.setUsername(user.getUsername());
        goods.setStatus(0);
        goods.setViews(0);
        goods.setCreatedTime(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date()));
        goodsService.addGoods(goods);
        return Result.success(true);
    }

    @GetMapping(path = "/byId")
    public @ResponseBody
    Result<?> getGoodsById(@RequestParam int id){
        Goods good = goodsService.getGoodsById(id);
        GoodsInfoDto info = new GoodsInfoDto();
        BeanUtils.copyProperties(good, info);
        Categories category = categoryService.getOneCategory(good.getCategoryId());
        info.setCategoryName(category.getName());
        User user = userService.getUser(good.getUsername());
        info.setUserAddress(user.getAddress());
        info.setUserPhone(user.getPhoneNumber());

        return Result.success(info);
    }

    @GetMapping(path = "/setStatus")
    public @ResponseBody
    Result<Boolean> setStatus(User user, @RequestParam int goodsId, @RequestParam int status){
        if (goodsService.setGoodsStatus(user.getUsername(), goodsId, status)){
            return Result.success(true);
        } else {
            return Result.fail(false);
        }
    }

    @PostMapping(path = "/update")
    public @ResponseBody
    Result<Boolean> updateGoods(User user, @RequestParam int goodsId, @RequestBody GoodsPojo goodsPojo){
        if (goodsService.updateGoods(user.getUsername(), goodsId, goodsPojo)){
            return Result.success(true);
        } else {
            return Result.fail(false);
        }
    }
}
