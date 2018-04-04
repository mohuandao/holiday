package com.example.holiday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//扫描mybatis的mapper,使用tk包注解
@MapperScan(basePackages = "com.example.holiday.mapper")
@ComponentScan(basePackages = {"com.example.holiday"})
public class HolidayApplication {

    public static void main(String[] args) {
        SpringApplication.run(HolidayApplication.class, args);
    }
}
