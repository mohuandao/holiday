package com.example.holiday.model;

import javax.persistence.*;

@Table(name = "h_user")
public class HUser {
    @Id
    @Column(name = "u_id")
    private Integer uId;

    @Column(name = "u_name")
    private String uName;

    @Column(name = "u_password")
    private String uPassword;

    private String email;

    /**
     * "0"无效,"1"有效
     */
    @Column(name = "is_valid")
    private Integer isValid;

    /**
     * 是否激活,默认不激活
     */
    @Column(name = "is_active")
    private Integer isActive;

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
     * @return u_name
     */
    public String getuName() {
        return uName;
    }

    /**
     * @param uName
     */
    public void setuName(String uName) {
        this.uName = uName;
    }

    /**
     * @return u_password
     */
    public String getuPassword() {
        return uPassword;
    }

    /**
     * @param uPassword
     */
    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取"0"无效,"1"有效
     *
     * @return is_valid - "0"无效,"1"有效
     */
    public Integer getIsValid() {
        return isValid;
    }

    /**
     * 设置"0"无效,"1"有效
     *
     * @param isValid "0"无效,"1"有效
     */
    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    /**
     * 获取是否激活,默认不激活
     *
     * @return is_active - 是否激活,默认不激活
     */
    public Integer getIsActive() {
        return isActive;
    }

    /**
     * 设置是否激活,默认不激活
     *
     * @param isActive 是否激活,默认不激活
     */
    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }
}