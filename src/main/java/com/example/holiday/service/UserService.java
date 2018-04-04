package com.example.holiday.service;

import com.example.holiday.model.SysUser;

import java.util.LinkedHashMap;
import java.util.List;


public interface UserService {
    void addUser(SysUser user);
    List<LinkedHashMap<String,Object>> select_me();
}
