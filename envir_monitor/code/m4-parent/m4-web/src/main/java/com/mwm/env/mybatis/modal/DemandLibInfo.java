package com.mwm.env.mybatis.modal;

public class DemandLibInfo {
    private Integer demandlibid;

    private Integer userid;

    private String demandlibname;

    private String demandlibdesc;

    private Long createdate;

    private String state;

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

    public String getDemandlibname() {
        return demandlibname;
    }

    public void setDemandlibname(String demandlibname) {
        this.demandlibname = demandlibname == null ? null : demandlibname.trim();
    }

    public String getDemandlibdesc() {
        return demandlibdesc;
    }

    public void setDemandlibdesc(String demandlibdesc) {
        this.demandlibdesc = demandlibdesc == null ? null : demandlibdesc.trim();
    }

    public Long getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Long createdate) {
        this.createdate = createdate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}