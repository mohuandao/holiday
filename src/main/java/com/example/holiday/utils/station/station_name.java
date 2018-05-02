package com.example.holiday.utils.station;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 将查询到的字典序列化到本地,不然每次查字典网络开销非常大
 */
public class station_name {

    public static void main(String[] args) {
        //执行一次就把map序列化到本地
        try {
            serializeMap();
            //System.out.println(getStation("IOQ"));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }

    private static Boolean serializeMap() throws URISyntaxException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        URI uri = new URIBuilder()
                .setScheme("https")
                .setHost("kyfw.12306.cn")
                .setPath("otn/resources/js/framework/station_name.js")
                .setParameter("station_version", "1.9053")
                .build();
        System.out.println(uri);
        HttpGet httpGet = new HttpGet(uri);
        httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.162 Safari/537.36");
        HashMap<String, String> map = new HashMap<>();
        HashMap<Object, Object> rev_map = new HashMap<>();
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String mess = EntityUtils.toString(entity);
            System.out.println(mess);//内容是全的
            String reg = "([\\u4e00-\\u9fa5]+)\\|([A-Z]+)";
            Pattern compile = Pattern.compile(reg);

            while (true) {
                Matcher matcher = compile.matcher(mess);
                if (matcher.find()) {
                    //System.out.println(matcher.group());
                    mess = mess.substring(mess.indexOf(matcher.group())+matcher.group().length());
                    String[] strings = matcher.group().split("\\|");
                    map.put(strings[1],strings[0]);
                    rev_map.put(strings[0],strings[1]);
                }else {
                    break;
                }
            }
            //将map序列化
            FileOutputStream out = new FileOutputStream("D:\\爬虫例子\\station.txt");
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(map);
            oos.close();

            FileOutputStream out1 = new FileOutputStream("D:\\爬虫例子\\rev_station.txt");
            ObjectOutputStream oos1 = new ObjectOutputStream(out1);
            oos1.writeObject(rev_map);
            oos1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
    /**
     * 读取序列化的map文件,由code得到城市名
     * @param code
     * @return
     * @throws URISyntaxException
     */
    public static String getCityByCode(String code) throws URISyntaxException {
        HashMap<String, String> map = new HashMap<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\爬虫例子\\station.txt"));
             map = (HashMap) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(map);
        return map.get(code);
    }


    public static String getCodeByCity(String city){
        HashMap<String, String> rev_map = new HashMap<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\爬虫例子\\rev_station.txt"));
            rev_map = (HashMap) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rev_map.get(city);
    }
}
