package com.example.libra.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.example.libra.common.Result;
import com.example.libra.controller.LoginRet.Login_ret;
import com.example.libra.controller.request.BaseRequest;
import com.example.libra.controller.request.LoginRequest;
import com.example.libra.entity.Admin;
import com.example.libra.entity.User;
import com.example.libra.exception.ServiceException;
import com.example.libra.mapper.AdminMapper;
import com.example.libra.service.IAdminService;
import com.example.libra.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class AdminService implements IAdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public List<Admin> list() {
        return adminMapper.list();
    }

    @Override
    public PageInfo<Admin> page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(),baseRequest.getPageSize());
        List<Admin> users = adminMapper.listByCondition(baseRequest);
        return new PageInfo<>(users);
    }

    @Override
    public void save(Admin obj) {
        Date date = new Date();
        String generatedString = DateUtil.format(date, "yyyyMMddHHmmssSSS") + Math.abs(IdUtil.fastSimpleUUID().hashCode()) ;
        String truncatedString = generatedString.substring(0, 21);
        obj.setLibrarynumber(truncatedString);
        adminMapper.save(obj);
    }



    @Override
    public Admin getbyId(Integer id){
        return adminMapper.getbyId(id);
    }

    @Override
    public void update(Admin obj) {
        adminMapper.updatebyId(obj);
    }


    @Override
    public void deletebyId(Integer id){
        adminMapper.deletebyId(id);
    }

    @Override
    public Login_ret login(LoginRequest request)
    {
        Admin admin = adminMapper.getbyLibrarynumberAndPassword(request);
        if(admin == null)
        {
            throw new ServiceException("用户名或密码错误");
        }
        Login_ret login_ret = new Login_ret();
        BeanUtils.copyProperties(admin,login_ret);
        return login_ret;

    }
}
