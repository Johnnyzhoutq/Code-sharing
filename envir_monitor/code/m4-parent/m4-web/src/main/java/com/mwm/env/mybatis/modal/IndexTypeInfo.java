package com.mwm.env.mybatis.modal;

import java.math.BigDecimal;

public class IndexTypeInfo {
    private Integer indextypeid;

    private Integer provideid;

    private String typenum;

    private String indextypename;

    private String timedomain;

    private String tdtype;

    private String tdcontent;

    private BigDecimal pricemultiple;

    private String typeflag;

    private Long createdate;

    private Long modifydate;

    public Integer getIndextypeid() {
        return indextypeid;
    }

    public void setIndextypeid(Integer indextypeid) {
        this.indextypeid = indextypeid;
    }

    public Integer getProvideid() {
        return provideid;
    }

    public void setProvideid(Integer provideid) {
        this.provideid = provideid;
    }

    public String getTypenum() {
        return typenum;
    }

    public void setTypenum(String typenum) {
        this.typenum = typenum == null ? null : typenum.trim();
    }

    public String getIndextypename() {
        return indextypename;
    }

    public void setIndextypename(String indextypename) {
        this.indextypename = indextypename == null ? null : indextypename.trim();
    }

    public String getTimedomain() {
        return timedomain;
    }

    public void setTimedomain(String timedomain) {
        this.timedomain = timedomain == null ? null : timedomain.trim();
    }

    public String getTdtype() {
        return tdtype;
    }

    public void setTdtype(String tdtype) {
        this.tdtype = tdtype == null ? null : tdtype.trim();
    }

    public String getTdcontent() {
        return tdcontent;
    }

    public void setTdcontent(String tdcontent) {
        this.tdcontent = tdcontent == null ? null : tdcontent.trim();
    }

    public BigDecimal getPricemultiple() {
        return pricemultiple;
    }

    public void setPricemultiple(BigDecimal pricemultiple) {
        this.pricemultiple = pricemultiple;
    }

    public String getTypeflag() {
        return typeflag;
    }

    public void setTypeflag(String typeflag) {
        this.typeflag = typeflag == null ? null : typeflag.trim();
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