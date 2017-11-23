package com.mwm.env.mybatis.modal;

import java.math.BigDecimal;

public class MemberInfo {
    private Integer memberid;

    private Integer provideid;

    private Integer userid;

    private Integer membertype;

    private Long openedtime;

    private String openedway;

    private String openedcontent;

    private BigDecimal amountpaid;

    private String amountway;

    private BigDecimal incomratio;

    private Long periodbegin;

    private Long periodend;

    private Long createdate;

    private Long modifydate;

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public Integer getProvideid() {
        return provideid;
    }

    public void setProvideid(Integer provideid) {
        this.provideid = provideid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getMembertype() {
        return membertype;
    }

    public void setMembertype(Integer membertype) {
        this.membertype = membertype;
    }

    public Long getOpenedtime() {
        return openedtime;
    }

    public void setOpenedtime(Long openedtime) {
        this.openedtime = openedtime;
    }

    public String getOpenedway() {
        return openedway;
    }

    public void setOpenedway(String openedway) {
        this.openedway = openedway == null ? null : openedway.trim();
    }

    public String getOpenedcontent() {
        return openedcontent;
    }

    public void setOpenedcontent(String openedcontent) {
        this.openedcontent = openedcontent == null ? null : openedcontent.trim();
    }

    public BigDecimal getAmountpaid() {
        return amountpaid;
    }

    public void setAmountpaid(BigDecimal amountpaid) {
        this.amountpaid = amountpaid;
    }

    public String getAmountway() {
        return amountway;
    }

    public void setAmountway(String amountway) {
        this.amountway = amountway == null ? null : amountway.trim();
    }

    public BigDecimal getIncomratio() {
        return incomratio;
    }

    public void setIncomratio(BigDecimal incomratio) {
        this.incomratio = incomratio;
    }

    public Long getPeriodbegin() {
        return periodbegin;
    }

    public void setPeriodbegin(Long periodbegin) {
        this.periodbegin = periodbegin;
    }

    public Long getPeriodend() {
        return periodend;
    }

    public void setPeriodend(Long periodend) {
        this.periodend = periodend;
    }

    public Long getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Long createdate) {
        this.createdate = createdate;
    }

    public Long getModifydate() {
        return modifydate;
    }

    public void setModifydate(Long modifydate) {
        this.modifydate = modifydate;
    }
}