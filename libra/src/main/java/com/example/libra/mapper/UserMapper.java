package com.example.libra.mapper;

import com.example.libra.controller.request.UserPageRequest;
import com.example.libra.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface UserMapper {

    //@Select("select * from library_user")
    List<User> list();

    List<User> listByCondition(UserPageRequest userPageRequest);

    void save(User user);
}
