package com.example.holiday.utils.station;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;



import org.apache.http.HttpEntity;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;


/**
 * 尝试下java爬虫
 */
public class spiderUtils {
    public static void main(String[] args) throws URISyntaxException {
        getINfo("沈阳","济南","2018-05-03");

    }

    public static List getINfo(String from_station,String to_station,String date) throws URISyntaxException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        String from_code = station_name.getCodeByCity(from_station);
        String ro_code = station_name.getCodeByCity(to_station);
        //uri的构造器
        URI uri = new URIBuilder()
                .setScheme("https")
                .setHost("kyfw.12306.cn")
                .setPath("/otn/leftTicket/query")
                .setParameter("leftTicketDTO.train_date", date) //2018-05-04
                .setParameter("leftTicketDTO.from_station", from_code)
                .setParameter("leftTicketDTO.to_station", ro_code)
                .setParameter("purpose_codes", "ADULT")
                .build();
        // HttpGet httpGet = new HttpGet("https://kyfw.12306.cn/otn/leftTicket/query?leftTicketDTO.train_date=2018-05-03&leftTicketDTO.from_station=HKN&leftTicketDTO.to_station=HAN&purpose_codes=ADULT");
        System.out.println(uri);
        HttpGet httpGet = new HttpGet(uri);
        httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.162 Safari/537.36");
        //System.out.println(httpGet.getURI());
        List<Map<String,String>> list = new ArrayList<>();
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            //System.out.println(entity);
            String message = EntityUtils.toString(entity);
            System.out.println(message);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(message);
            JsonNode result = node.get("data").get("result");
            System.out.println(result.get(1));
            //直接遍历result


            for (int i = 0;i < result.size();i++) {
                HashMap<String, String> map = new LinkedHashMap<>(); //map要放在循环里,list里要放很多map对象,放在外面只有最后一个结果
                String str = String.valueOf(result.get(i));
                //System.out.println(str);
                String[] strings = str.split("\\|");  //加两个反斜线转义
                String train_no = strings[3];

                String from_station_code = strings[6];
                String from_station_name = station_name.getCityByCode(from_station_code);

                String to_station_code = strings[7];
                String to_station_name = station_name.getCityByCode(to_station_code);

                String start_time = strings[8];
                String arrive_time = strings[9];
                String first_class_seat = strings[31] ; //一等座
                String second_class_seat = strings[30]; //二等座
                String soft_sleep = strings[23]; //软卧
                String hard_sleep = strings[28]; //硬卧
                String hard_seat = strings[29]; //硬座
                String no_seat = strings[26]; //无座
                map.put("train_no",train_no);
                map.put("from_station_name",from_station_name);
                map.put("to_station_name",to_station_name);
                map.put("start_time",start_time);
                map.put("arrive_time",arrive_time);
                map.put("first_class_seat",first_class_seat);
                map.put("second_class_seat",second_class_seat);
                map.put("soft_sleep",soft_sleep);
                map.put("hard_sleep",hard_sleep);
                map.put("hard_seat",hard_seat);
                map.put("no_seat",no_seat);
                //System.out.println(map);
                list.add(map);

            }
            System.out.println(list);
            System.out.println("-------------------------------------------------");
           // System.out.println(getStation("WCN"));
            response.close();
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


}
