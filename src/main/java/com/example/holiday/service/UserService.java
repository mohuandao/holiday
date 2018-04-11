package com.example.holiday.service;

import com.example.holiday.model.SysUser;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public interface UserService {
    void addUser(SysUser user);
    List<LinkedHashMap<String,Object>> select_me();

    Map<String,Object> login(String name,String password);

    Map<String,Object> reg(String name,String password);
}
