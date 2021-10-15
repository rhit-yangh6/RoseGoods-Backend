package com.example.rosegoodsbackend.rdbms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Tests")
public class TestController {

    @PostMapping(path = "/helloworld")
    public @ResponseBody
    String getBackups(){
        return "hello world!";
    }
}
