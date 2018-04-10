package com.example.holiday.controller;

import com.example.holiday.model.SysUser;
import com.example.holiday.service.UserService;
import com.example.holiday.utils.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private UserService userService;

    /*@Autowired
    private ExcelUtils excelUtils;*/
    @RequestMapping(value = {"/"})

    public String hello(){
        return "login";
    }

    //关闭首页路口,创建sys_user本是一个测试表,现在重新创建一个测试表
    /*@RequestMapping("/index")
    public String index(){
        return "index";
    }*/

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

    @RequestMapping("export_1")
    public void export_excel(HttpServletResponse response) throws IOException {
        //定表名
        Date date = new Date();
        String time = new SimpleDateFormat("yyyyMMddHHmmss").format(date);
        String filename = "wdtest"+time+".xls";
        //从后台查出数据集
        List<LinkedHashMap<String,Object>> list_link = userService.select_me();
        String title = "测试表";
        //headers来自于list_link

        ArrayList<String> headers = new ArrayList<>();
        for (String key:
             list_link.get(0).keySet()) {
            headers.add(key);
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = ExcelUtils.export(list_link, title, headers, out);

        response.reset();
        response.setContentType("application/msexcel;charset=utf-8");
        response.setHeader("Content-disposition", "attachment;filename="+ new String((filename).getBytes()));

        OutputStream ou = response.getOutputStream();

        BufferedInputStream bis = new BufferedInputStream(in);
        BufferedOutputStream bos = new BufferedOutputStream(ou);
        byte[] buff = new byte[2048];
        int byteRead;
        while(-1 != (byteRead = bis.read(buff, 0, buff.length))) {
            bos.write(buff, 0, byteRead);
        }
        bis.close();
        bos.close();
        //return true;
    }
}
