package com.example.rosegoodsbackend.rdbms.controller;

import com.example.rosegoodsbackend.rdbms.common.Result;
import com.example.rosegoodsbackend.rdbms.entity.User;
import com.example.rosegoodsbackend.rdbms.pojos.UserInfoPojo;
import com.example.rosegoodsbackend.rdbms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping(path = "/view")
    public @ResponseBody
    Result<?> showInfo(User user){
        return Result.success(user);
    }

    @PostMapping(path = "/infoChange")
    public @ResponseBody
    Result<Boolean> modifyInfo(User user, @RequestBody UserInfoPojo info){
        if (userService.modifyInfo(user.getUsername(), info)) {
            return Result.success("Successfully modified user info");
        } else {
            return Result.fail("Failed to modify user info");
        }
    }

    /*@GetMapping(path = "/address")
    public @ResponseBody
    Result<Boolean> modifyAddr(User user, @RequestParam String address){
        if (userService.modifyAddress(user.getUsername(), address)) {
            return Result.success("Successfully modified address");
        } else {
            return Result.fail("Failed to modify address");
        }
    }

    @GetMapping(path = "/phone")
    public @ResponseBody
    Result<Boolean> modifyPhone(User user, @RequestParam String phone){
        if (userService.modifyPhone(user.getUsername(), phone)) {
            return Result.success("Successfully modified phone");
        } else {
            return Result.fail("Failed to modify phone");
        }
    }

    @GetMapping(path = "/name")
    public @ResponseBody
    Result<Boolean> modifyActualName(User user, @RequestParam String actualName){
        if (userService.modifyName(user.getUsername(), actualName)) {
            return Result.success("Successfully modified name");
        } else {
            return Result.fail("Failed to modify name");
        }
    }*/

}
