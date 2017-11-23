package com.mwm.env.mybatis.modal;

import java.math.BigDecimal;

public class DataGoodsInfo {
    private Integer goods;

    private Integer provideid;

    private Integer indexid;

    private Integer reportid;

    private Integer goodstype;

    private String sell;

    private String units;

    private BigDecimal unitprice;

    private String location;

    private String expirydate;

    private String shelves;

    private String auditstatus;

    private Long createdate;

    private Long modifydate;

    private Long startdate;

    private Long enddate;

    private String state;

    private String simpletimedetail;

    private Long simpletime;

    private String lon;

    private String lat;

    private Integer ranges;

    public Integer getGoods() {
        return goods;
    }

    public void setGoods(Integer goods) {
        this.goods = goods;
    }

    public Integer getProvideid() {
        return provideid;
    }

    public void setProvideid(Integer provideid) {
        this.provideid = provideid;
    }

    public Integer getIndexid() {
        return indexid;
    }

    public void setIndexid(Integer indexid) {
        this.indexid = indexid;
    }

    public Integer getReportid() {
        return reportid;
    }

    public void setReportid(Integer reportid) {
        this.reportid = reportid;
    }

    public Integer getGoodstype() {
        return goodstype;
    }

    public void setGoodstype(Integer goodstype) {
        this.goodstype = goodstype;
    }

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell == null ? null : sell.trim();
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units == null ? null : units.trim();
    }

    public BigDecimal getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(BigDecimal unitprice) {
        this.unitprice = unitprice;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(String expirydate) {
        this.expirydate = expirydate == null ? null : expirydate.trim();
    }

    public String getShelves() {
        return shelves;
    }

    public void setShelves(String shelves) {
        this.shelves = shelves == null ? null : shelves.trim();
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

    public Long getModifydate() {
        return modifydate;
    }

    public void setModifydate(Long modifydate) {
        this.modifydate = modifydate;
    }

    public Long getStartdate() {
        return startdate;
    }

    public void setStartdate(Long startdate) {
        this.startdate = startdate;
    }

    public Long getEnddate() {
        return enddate;
    }

    public void setEnddate(Long enddate) {
        this.enddate = enddate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getSimpletimedetail() {
        return simpletimedetail;
    }

    public void setSimpletimedetail(String simpletimedetail) {
        this.simpletimedetail = simpletimedetail == null ? null : simpletimedetail.trim();
    }

    public Long getSimpletime() {
        return simpletime;
    }

    public void setSimpletime(Long simpletime) {
        this.simpletime = simpletime;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon == null ? null : lon.trim();
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }

    public Integer getRanges() {
        return ranges;
    }

    public void setRanges(Integer ranges) {
        this.ranges = ranges;
    }
}