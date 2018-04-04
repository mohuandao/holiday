package com.example.holiday.mapper;

import com.example.holiday.model.SysUser;
import com.example.holiday.utils.MyMapper;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;

@Repository
public interface SysUserMapper extends MyMapper<SysUser> {
    void add(SysUser user);
    List<LinkedHashMap<String,Object>> list_link();

}