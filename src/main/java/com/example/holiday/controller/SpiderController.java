package com.example.holiday.controller;

import com.example.holiday.utils.station.spiderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SpiderController {

    @RequestMapping("/getInfo")
    @ResponseBody
    public List getInfo(@RequestParam String from_station,
                        @RequestParam String to_station,
                        @RequestParam String date) {
        List<Object> list = new ArrayList<>();
        try {
             list = spiderUtils.getINfo(from_station, to_station, date);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return list;
    }
}
