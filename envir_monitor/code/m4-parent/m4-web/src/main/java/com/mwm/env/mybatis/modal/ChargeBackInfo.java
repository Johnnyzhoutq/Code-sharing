package com.mwm.env.mybatis.modal;

import java.math.BigDecimal;

public class ChargeBackInfo {
    private Integer backid;

    private Integer orderid;

    private String ordernum;

    private Integer userid;

    private String username;

    private Integer provideid;

    private String providename;

    private String backuser;

    private BigDecimal amout;

    private String process;

    private String auditstatus;

    private Long createdate;

    public Integer getBackid() {
        return backid;
    }

    public void setBackid(Integer backid) {
        this.backid = backid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum == null ? null : ordernum.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getProvideid() {
        return provideid;
    }

    public void setProvideid(Integer provideid) {
        this.provideid = provideid;
    }

    public String getProvidename() {
        return providename;
    }

    public void setProvidename(String providename) {
        this.providename = providename == null ? null : providename.trim();
    }

    public String getBackuser() {
        return backuser;
    }

    public void setBackuser(String backuser) {
        this.backuser = backuser == null ? null : backuser.trim();
    }

    public BigDecimal getAmout() {
        return amout;
    }

    public void setAmout(BigDecimal amout) {
        this.amout = amout;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process == null ? null : process.trim();
    }

    public String getAuditstatus() {
        return auditstatus;
    }

    public void setAuditstatus(String auditstatus) {
        this.auditstatus = auditstatus == null ? null : auditstatus.trim();
    }

    public Long getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Long createdate) {
        this.createdate = createdate;
    }
}