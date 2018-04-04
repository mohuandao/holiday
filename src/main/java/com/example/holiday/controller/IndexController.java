package com.example.holiday.controller;

import com.example.holiday.model.SysUser;
import com.example.holiday.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = {"/"})
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("adduser")
    public void addUser(@RequestParam String name,@RequestParam String sex,
                        @RequestParam int age ,@RequestParam String hobby) {
        SysUser user = new SysUser();
        user.setName(name);
        user.setSex(sex);
        user.setAge(age);
        user.setHobby(hobby);
        userService.addUser(user);
    }

    @RequestMapping("export")
    @ResponseBody
    public List<LinkedHashMap<String,Object>> export() {
        System.out.println(userService.select_me());
        return userService.select_me();
    }
}
