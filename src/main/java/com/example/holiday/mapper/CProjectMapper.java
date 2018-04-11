package com.example.holiday.mapper;

import com.example.holiday.model.CProject;
import com.example.holiday.utils.MyMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CProjectMapper extends MyMapper<CProject> {
    List<Map<String,Object>> list();
}