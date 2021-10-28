package com.example.rosegoodsbackend.rdbms.controller;

import com.example.rosegoodsbackend.rdbms.common.Result;
import com.example.rosegoodsbackend.rdbms.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping(path = "/all")
    public @ResponseBody
    Result<?> getCategories(){
        return Result.success(categoryService.getAllCategories());
    }
}
