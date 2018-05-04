package com.example.holiday.controller;

import com.example.holiday.utils.station.spiderUtils;
import com.example.holiday.utils.station.station_name;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class SpiderController {
    //跳转到查询页
    @RequestMapping("/station")
    public String station() {
        return "station";
    }
    /**
     * 接口
     * @param from_station
     * @param to_station
     * @param date
     * @return
     */
    @RequestMapping("/getInfo")
    @ResponseBody
    public Map getInfo(@RequestParam String from_station,
                       @RequestParam String to_station,
                       @RequestParam String date) throws ParseException {
        List<Object> list = new ArrayList<>();
        //String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Date today = new Date();
        Date v_date = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        try {
            //做一个判断,输入信息正常时才调用方法
             if (null == station_name.getCodeByCity(from_station) | null == station_name.getCodeByCity(to_station)
                     | v_date.before(today)) {
                 list = null;
             }else {
                 list = spiderUtils.getINfo(from_station, to_station, date);
             }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        //返回表格接受的数据
        HashMap<Object, Object> map = new HashMap<>();
        map.put("code","0");
        map.put("msg","");
        map.put("count",1000);
        map.put("data",list);
        return map;
    }
}
