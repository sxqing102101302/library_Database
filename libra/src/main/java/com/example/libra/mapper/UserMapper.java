package com.example.libra.mapper;

import com.example.libra.controller.request.BaseRequest;
import com.example.libra.controller.request.UserPageRequest;
import com.example.libra.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface UserMapper {

    //@Select("select * from library_user")
    List<User> list();

    List<User> listByCondition(BaseRequest baseRequest);

    void save(User user);

    User getbyId(Integer id);

    void updatebyId(User user);

    void deletebyId(Integer id);
}
