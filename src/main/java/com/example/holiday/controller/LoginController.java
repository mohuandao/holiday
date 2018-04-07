package com.example.holiday.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by wangdong on 2018/4/7.
 */
@Controller
public class LoginController {
    @RequestMapping(value = "login" ,method = RequestMethod.POST)
    public String login(@RequestParam String name,@RequestParam String password) {

        return "";
    }
}
