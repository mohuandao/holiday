package com.example.holiday.mapper;

import com.example.holiday.model.HUser;
import com.example.holiday.utils.MyMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface HUserMapper extends MyMapper<HUser> {
    HUser selectByName(String name);

    void addUser(HUser user);
}