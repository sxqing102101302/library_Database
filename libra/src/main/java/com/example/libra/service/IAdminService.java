package com.example.libra.service;

import com.example.libra.controller.LoginRet.Login_ret;
import com.example.libra.controller.request.BaseRequest;
import com.example.libra.controller.request.LoginRequest;
import com.example.libra.entity.Admin;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IAdminService {


    List<Admin> list();

    PageInfo<Admin> page(BaseRequest baseRequest);

    void save(Admin obj);

    Admin getbyId(Integer id);

    void update(Admin obj);

    void deletebyId(Integer id);

    Login_ret login(LoginRequest request);
}
