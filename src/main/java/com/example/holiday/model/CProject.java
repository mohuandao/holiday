package com.example.holiday.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "c_project")
public class CProject {
    /**
     * 资源号
     */
    @Id
    @Column(name = "RESOURCE_ID")
    private String resourceId;

    /**
     * 项目名称
     */
    @Column(name = "XMMC")
    private String xmmc;

    /**
     * 教职工编号
     */
    @Column(name = "JZGBH")
    private String jzgbh;

    /**
     * 学院编号
     */
    @Column(name = "XYBH")
    private String xybh;

    /**
     *  年份
     */
    @Column(name = "NF")
    private String nf;

    /**
     * 入库方式值
     */
    @Column(name = "RKFS")
    private String rkfs;

    /**
     * 入库人
     */
    @Column(name = "CREATE_USER")
    private String createUser;

    /**
     * 入库时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 最后编辑人
     */
    @Column(name = "MODIFY_USER")
    private String modifyUser;

    /**
     * 最后编辑时间
     */
    @Column(name = "MODIFY_TIME")
    private Date modifyTime;

    /**
     * 审批结果
     */
    @Column(name = "SPJG")
    private String spjg;

    /**
     * 流程状态
     */
    @Column(name = "LCZT")
    private String lczt;

    /**
     * 获取资源号
     *
     * @return RESOURCE_ID - 资源号
     */
    public String getResourceId() {
        return resourceId;
    }

    /**
     * 设置资源号
     *
     * @param resourceId 资源号
     */
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * 获取项目名称
     *
     * @return XMMC - 项目名称
     */
    public String getXmmc() {
        return xmmc;
    }

    /**
     * 设置项目名称
     *
     * @param xmmc 项目名称
     */
    public void setXmmc(String xmmc) {
        this.xmmc = xmmc;
    }

    /**
     * 获取教职工编号
     *
     * @return JZGBH - 教职工编号
     */
    public String getJzgbh() {
        return jzgbh;
    }

    /**
     * 设置教职工编号
     *
     * @param jzgbh 教职工编号
     */
    public void setJzgbh(String jzgbh) {
        this.jzgbh = jzgbh;
    }

    /**
     * 获取学院编号
     *
     * @return XYBH - 学院编号
     */
    public String getXybh() {
        return xybh;
    }

    /**
     * 设置学院编号
     *
     * @param xybh 学院编号
     */
    public void setXybh(String xybh) {
        this.xybh = xybh;
    }

    /**
     * 获取 年份
     *
     * @return NF -  年份
     */
    public String getNf() {
        return nf;
    }

    /**
     * 设置 年份
     *
     * @param nf  年份
     */
    public void setNf(String nf) {
        this.nf = nf;
    }

    /**
     * 获取入库方式值
     *
     * @return RKFS - 入库方式值
     */
    public String getRkfs() {
        return rkfs;
    }

    /**
     * 设置入库方式值
     *
     * @param rkfs 入库方式值
     */
    public void setRkfs(String rkfs) {
        this.rkfs = rkfs;
    }

    /**
     * 获取入库人
     *
     * @return CREATE_USER - 入库人
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 设置入库人
     *
     * @param createUser 入库人
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * 获取入库时间
     *
     * @return CREATE_TIME - 入库时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置入库时间
     *
     * @param createTime 入库时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取最后编辑人
     *
     * @return MODIFY_USER - 最后编辑人
     */
    public String getModifyUser() {
        return modifyUser;
    }

    /**
     * 设置最后编辑人
     *
     * @param modifyUser 最后编辑人
     */
    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    /**
     * 获取最后编辑时间
     *
     * @return MODIFY_TIME - 最后编辑时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置最后编辑时间
     *
     * @param modifyTime 最后编辑时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取审批结果
     *
     * @return SPJG - 审批结果
     */
    public String getSpjg() {
        return spjg;
    }

    /**
     * 设置审批结果
     *
     * @param spjg 审批结果
     */
    public void setSpjg(String spjg) {
        this.spjg = spjg;
    }

    /**
     * 获取流程状态
     *
     * @return LCZT - 流程状态
     */
    public String getLczt() {
        return lczt;
    }

    /**
     * 设置流程状态
     *
     * @param lczt 流程状态
     */
    public void setLczt(String lczt) {
        this.lczt = lczt;
    }
}