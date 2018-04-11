package com.example.holiday.service.impl;

import com.example.holiday.mapper.CProjectMapper;
import com.example.holiday.model.CProject;
import com.example.holiday.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private CProjectMapper cProjectMapper;
    @Override
    public List<CProject> select_all() {

        return cProjectMapper.selectAll();
        //return null;
    }

    @Override
    public List<Map<String, Object>> select_all1() {

        return cProjectMapper.list();
    }
}
