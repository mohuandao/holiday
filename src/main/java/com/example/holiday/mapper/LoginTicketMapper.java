package com.example.holiday.mapper;

import com.example.holiday.model.LoginTicket;
import com.example.holiday.utils.MyMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginTicketMapper extends MyMapper<LoginTicket> {
    void addTicket(LoginTicket ticket);
}