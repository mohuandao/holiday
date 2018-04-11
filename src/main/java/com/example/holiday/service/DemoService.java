package com.example.holiday.service;

import com.example.holiday.model.CProject;

import java.util.List;
import java.util.Map;


public interface DemoService {
    List<CProject> select_all();

    List<Map<String,Object>> select_all1();
}
