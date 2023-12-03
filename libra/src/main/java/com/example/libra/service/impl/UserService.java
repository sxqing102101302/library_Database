package com.example.libra.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.example.libra.controller.request.BaseRequest;
import com.example.libra.controller.request.UserPageRequest;
import com.example.libra.entity.User;
import com.example.libra.mapper.UserMapper;
import com.example.libra.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> list() {
        return userMapper.list();
    }

    @Override
    public PageInfo<User> page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(),baseRequest.getPageSize());
        List<User> users = userMapper.listByCondition(baseRequest);
        return new PageInfo<>(users);
    }

    @Override
    public void save(User user){
        //Date date = new Date();
        //user.setLibrarynumber(DateUtil.format(date,"yyyyMMdd") + IdUtil.fastSimpleUUID());
        Date date = new Date();
        String generatedString = DateUtil.format(date, "yyyyMMddHHmmssSSS") + Math.abs(IdUtil.fastSimpleUUID().hashCode()) ;
        String truncatedString = generatedString.substring(0, 21);
        user.setLibrarynumber(truncatedString);
        userMapper.save(user);
    }

    @Override
    public User getbyId(Integer id){
        return userMapper.getbyId(id);
    }

    @Override
    public void update(User user){
       userMapper.updatebyId(user);
    }

    @Override
    public void deletebyId(Integer id){
        userMapper.deletebyId(id);
    }
}
