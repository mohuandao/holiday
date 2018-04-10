package com.example.holiday.controller;

import com.example.holiday.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by wangdong on 2018/4/7.
 */
@Controller
public class LoginController {

    public static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    UserService userService;
    @RequestMapping(value = "/reg",method = RequestMethod.POST)
    public String reg(Model model,@RequestParam String name,@RequestParam String password,
                      @RequestParam Boolean rememberme,HttpServletResponse response) {
        try {
            Map<String, Object> map = userService.reg(name, password);
            if (map.containsKey("ticket")) {
                Cookie cookie = new Cookie("ticket", map.get("ticket").toString());
                cookie.setPath("/");
                if (rememberme){
                    cookie.setMaxAge(3600*24*5);//5天
                }
                response.addCookie(cookie);
                return "redirect:/index";
            }else {
                model.addAttribute("msg",map.get("msg"));
                return "login";
            }
        }catch (Exception e) {
            logger.error("注册异常"+e.getMessage());
            model.addAttribute("msg","服务器错误");
            return "login";
        }

    }

    @RequestMapping(value = "login" ,method = RequestMethod.POST)
    public String login(Model model, @RequestParam String name, @RequestParam String password,
                        @RequestParam Boolean rememberme, HttpServletResponse response) {

        try {
            Map<String, Object> map = userService.login(name, password);
            if (map.containsKey("ticket")){
                //登陆成功,存入cookie
                Cookie cookie = new Cookie("ticket", map.get("ticket").toString());
                cookie.setPath("/");
                if (rememberme){
                    cookie.setMaxAge(3600*24*5);//5天
                }
                response.addCookie(cookie);
               model.addAttribute("user",map.get("user"));
                return "index";
            }else {
                model.addAttribute("msg",map.get("msg"));

                return "login";
            }
        } catch (Exception e) {
            logger.error("登陆异常"+e.getMessage());

            return "login";
        }
        //return "";
    }
}
