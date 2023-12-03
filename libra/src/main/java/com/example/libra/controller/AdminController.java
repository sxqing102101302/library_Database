package com.example.libra.controller;

import com.example.libra.common.Result;
import com.example.libra.controller.LoginRet.Login_ret;
import com.example.libra.controller.request.AdminPageRequest;
import com.example.libra.controller.request.LoginRequest;
import com.example.libra.controller.request.UserPageRequest;
import com.example.libra.entity.Admin;
import com.example.libra.service.IAdminService;
import com.example.libra.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    IAdminService adminService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest request){
        Login_ret login = adminService.login(request);
        if(login == null)
        {
            return Result.error("用户名或密码错误");
        }
        return  Result.success(login);
    }

    @PostMapping("/save")
    public Result save(@RequestBody Admin obj){
        adminService.save(obj);
        return  Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Admin obj){
        adminService.update(obj);
        return  Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        adminService.deletebyId(id);
        return  Result.success();
    }

    @GetMapping("/{id}")
    public Result getbyId(@PathVariable Integer id)
    {
        Admin obj = adminService.getbyId(id);
        return Result.success(obj);
    }

    @GetMapping("/list")
    public Result list()
    {
        List<Admin> list = adminService.list();
        return Result.success(list);
    }

    @GetMapping("/page")
    public Result page(AdminPageRequest PageRequest)
    {
        return Result.success(adminService.page(PageRequest));
    }
}
