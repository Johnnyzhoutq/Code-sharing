package com.mwm.env.mybatis.modal;

import java.math.BigDecimal;

public class MemberShipInfo {
    private Integer membershipid;

    private String membershipcode;

    private String membershipname;

    private Integer regulation;

    private String applyway;

    private String amoutpaid;

    private BigDecimal incomratio;

    private String period;

    private Long createdate;

    public Integer getMembershipid() {
        return membershipid;
    }

    public void setMembershipid(Integer membershipid) {
        this.membershipid = membershipid;
    }

    public String getMembershipcode() {
        return membershipcode;
    }

    public void setMembershipcode(String membershipcode) {
        this.membershipcode = membershipcode == null ? null : membershipcode.trim();
    }

    public String getMembershipname() {
        return membershipname;
    }

    public void setMembershipname(String membershipname) {
        this.membershipname = membershipname == null ? null : membershipname.trim();
    }

    public Integer getRegulation() {
        return regulation;
    }

    public void setRegulation(Integer regulation) {
        this.regulation = regulation;
    }

    public String getApplyway() {
        return applyway;
    }

    public void setApplyway(String applyway) {
        this.applyway = applyway == null ? null : applyway.trim();
    }

    public String getAmoutpaid() {
        return amoutpaid;
    }

    public void setAmoutpaid(String amoutpaid) {
        this.amoutpaid = amoutpaid == null ? null : amoutpaid.trim();
    }

    public BigDecimal getIncomratio() {
        return incomratio;
    }

    public void setIncomratio(BigDecimal incomratio) {
        this.incomratio = incomratio;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period == null ? null : period.trim();
    }

    public Long getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Long createdate) {
        this.createdate = createdate;
    }
}