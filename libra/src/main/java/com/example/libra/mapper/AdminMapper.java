package com.example.libra.mapper;

import com.example.libra.controller.request.BaseRequest;
import com.example.libra.controller.request.LoginRequest;
import com.example.libra.controller.request.UserPageRequest;
import com.example.libra.entity.Admin;
import com.example.libra.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {

    List<Admin> list();

    List<Admin> listByCondition(BaseRequest baseRequest);

    void save(Admin obj);

    Admin getbyId(Integer id);

    void updatebyId(Admin user);

    void deletebyId(Integer id);

    Admin getbyLibrarynumberAndPassword(LoginRequest request);
}
