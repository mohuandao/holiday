package com.example.holiday.service.impl;

import com.example.holiday.mapper.HUserMapper;
import com.example.holiday.mapper.SysUserMapper;
import com.example.holiday.model.HUser;
import com.example.holiday.model.LoginTicket;
import com.example.holiday.model.SysUser;
import com.example.holiday.service.UserService;
import com.example.holiday.utils.HolidayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    HUserMapper hUserMapper;
   /* @Autowired
    HolidayUtils holidayUtils;*/


    public void addUser(SysUser user) {
        userMapper.add(user);
    }

    @Override
    public List<LinkedHashMap<String, Object>> select_me() {
        return userMapper.list_link();
    }

    @Override
    public Map<String, Object> login(String name, String password) {
        //存信息
        Map<String, Object> map = new HashMap<>();
        if (StringUtils.isEmpty(name)) {
            map.put("msg","用户名不能为空");
            return map;
        }
        if (StringUtils.isEmpty(password)) {
            map.put("msg","密码不能为空");
            return map;

        }
        HUser user = hUserMapper.selectByName(name);
        if (user == null) {
            map.put("msg","用户名不存在");
            return map;
        }
        if (!HolidayUtils.MD5(password).equals(user.getuPassword())) {
            map.put("msg","密码不正确");
            return map;
        }
        /*//密码强度
        user = new HUser();
        user.setuName(name);
        //也可以密码加上盐后生产md5
        user.setuPassword(HolidayUtils.MD5(password));*/
        //登录
        String ticket = addTicket(user.getuId());
        map.put("ticket",ticket);
        map.put("userId",user.getuId());
        return map;
    }

    //产生ticket
    private String addTicket(int uid) {
        LoginTicket ticket = new LoginTicket();
        ticket.setuId(uid);
        Date date = new Date();
        date.setTime(date.getTime()+1000*3600*24);//24小时后过期
        ticket.setExpired(date);
        ticket.setStatus(0);
        ticket.setTicket(UUID.randomUUID().toString().replace("-",""));
        return ticket.getTicket();
    }



}
