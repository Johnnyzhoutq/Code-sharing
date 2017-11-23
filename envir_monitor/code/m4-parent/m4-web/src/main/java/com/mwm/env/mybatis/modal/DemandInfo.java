package com.mwm.env.mybatis.modal;

public class DemandInfo {
    private Integer demandid;

    private Integer demandlibid;

    private Integer userid;

    private String demandname;

    public Integer getDemandid() {
        return demandid;
    }

    public void setDemandid(Integer demandid) {
        this.demandid = demandid;
    }

    public Integer getDemandlibid() {
        return demandlibid;
    }

    public void setDemandlibid(Integer demandlibid) {
        this.demandlibid = demandlibid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getDemandname() {
        return demandname;
    }

    public void setDemandname(String demandname) {
        this.demandname = demandname == null ? null : demandname.trim();
    }
}