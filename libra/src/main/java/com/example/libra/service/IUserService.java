package com.example.libra.service;

import com.example.libra.controller.request.BaseRequest;
import com.example.libra.controller.request.UserPageRequest;
import com.example.libra.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IUserService {


    List<User> list();

    PageInfo<User> page(BaseRequest baseRequest);

    void save(User user);

    User getbyId(Integer id);

    void update(User user);

    void deletebyId(Integer id);
}
