package com.example.libra.service;

import com.example.libra.controller.request.UserPageRequest;
import com.example.libra.entity.User;

import java.util.List;

public interface IUserService {


    List<User> list();

    Object page(UserPageRequest userPageRequest);

    void save(User user);
}
