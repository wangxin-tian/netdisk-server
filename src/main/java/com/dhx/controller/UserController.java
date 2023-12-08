package com.dhx.controller;

import com.dhx.config.AjaxResult;
import com.dhx.config.Jwt;
import com.dhx.config.Md5Utils;
import com.dhx.config.Result;
import com.dhx.pojo.User;
import com.dhx.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserSevice service;

    @GetMapping("/")
    public Object getAllUsers() {
        List<User> users = service.getAllUsers();
        return AjaxResult.success("success", users);
    }

    @PostMapping("/login")
    public Result<User> getUser(@RequestBody User body, @RequestAttribute("_id") Object str) {
        String _id = String.valueOf(str);
        System.out.println("========================="+ _id);
        if (_id != "") {
            User user = service.getUserById(_id.split(" ")[0]);
            user.token = _id.split(" ")[1];
            System.out.println("------------------------"+ user + "\n " + _id);
            return Result.suc(user);
        }
        if (body.getUsername() == null || body.getPassword() == null) {
            return Result.fail("请输入正确的用户名或密码");
        }
        User user = service.getUser(body.getUsername(), Md5Utils.md5(body.getPassword()));
        if (user == null) {
           return Result.fail("找不到用户");
        }
        user.setPassword("");
        user.token = Jwt.generateToken(user.getId());
        return Result.suc(user);
    }


}
