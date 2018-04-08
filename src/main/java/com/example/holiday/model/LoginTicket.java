package com.example.holiday.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "login_ticket")
public class LoginTicket {
    @Id
    private Integer id;

    @Column(name = "u_id")
    private Integer uId;

    /**
     * 过期时间
     */
    private Date expired;

    /**
     * 状态,0无效,1有效
     */
    private Integer status;

    private String ticket;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return u_id
     */
    public Integer getuId() {
        return uId;
    }

    /**
     * @param uId
     */
    public void setuId(Integer uId) {
        this.uId = uId;
    }

    /**
     * 获取过期时间
     *
     * @return expired - 过期时间
     */
    public Date getExpired() {
        return expired;
    }

    /**
     * 设置过期时间
     *
     * @param expired 过期时间
     */
    public void setExpired(Date expired) {
        this.expired = expired;
    }

    /**
     * 获取状态,0无效,1有效
     *
     * @return status - 状态,0无效,1有效
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态,0无效,1有效
     *
     * @param status 状态,0无效,1有效
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return ticket
     */
    public String getTicket() {
        return ticket;
    }

    /**
     * @param ticket
     */
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}