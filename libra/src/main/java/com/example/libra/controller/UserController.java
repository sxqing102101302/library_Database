package com.example.libra.controller;

import com.example.libra.common.Result;
import com.example.libra.controller.request.UserPageRequest;
import com.example.libra.entity.User;
import com.example.libra.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping("/save")
    public Result save(@RequestBody User user){
        userService.save(user);
        return  Result.success();
    }

    @GetMapping("/list")
    public Result list()
    {
        List<User> users = userService.list();
        return Result.success(users);
    }

    @GetMapping("/page")
    public Result page(UserPageRequest userPageRequest)
    {
        return Result.success(userService.page(userPageRequest));
    }
}
