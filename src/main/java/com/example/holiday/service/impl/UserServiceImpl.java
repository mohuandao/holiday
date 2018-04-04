package com.example.holiday.service.impl;

import com.example.holiday.mapper.SysUserMapper;
import com.example.holiday.model.SysUser;
import com.example.holiday.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private SysUserMapper userMapper;



    public void addUser(SysUser user) {
        userMapper.add(user);
    }

    @Override
    public List<LinkedHashMap<String, Object>> select_me() {
        return userMapper.list_link();
    }

    /*public void ss() {
        userMapper.selectAll();
    }*/

}
