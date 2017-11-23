package com.mwm.env.mybatis.modal;

import java.math.BigDecimal;

public class SlaveOrderInfo {
    private Long slaveid;

    private Long masterid;

    private Integer provideid;

    private String slavenum;

    private BigDecimal recivable;

    private BigDecimal paidprice;

    private BigDecimal penaltyprice;

    private BigDecimal refund;

    private BigDecimal incomeratio;

    private String orderstate;

    private String deliverynum;

    private Long deliverydate;

    private Long recipdate;

    private Long platformdate;

    private Long completedate;

    private Long createdate;

    private Long modifydate;

    private Integer goods;

    private String datagoods;

    public Long getSlaveid() {
        return slaveid;
    }

    public void setSlaveid(Long slaveid) {
        this.slaveid = slaveid;
    }

    public Long getMasterid() {
        return masterid;
    }

    public void setMasterid(Long masterid) {
        this.masterid = masterid;
    }

    public Integer getProvideid() {
        return provideid;
    }

    public void setProvideid(Integer provideid) {
        this.provideid = provideid;
    }

    public String getSlavenum() {
        return slavenum;
    }

    public void setSlavenum(String slavenum) {
        this.slavenum = slavenum == null ? null : slavenum.trim();
    }

    public BigDecimal getRecivable() {
        return recivable;
    }

    public void setRecivable(BigDecimal recivable) {
        this.recivable = recivable;
    }

    public BigDecimal getPaidprice() {
        return paidprice;
    }

    public void setPaidprice(BigDecimal paidprice) {
        this.paidprice = paidprice;
    }

    public BigDecimal getPenaltyprice() {
        return penaltyprice;
    }

    public void setPenaltyprice(BigDecimal penaltyprice) {
        this.penaltyprice = penaltyprice;
    }

    public BigDecimal getRefund() {
        return refund;
    }

    public void setRefund(BigDecimal refund) {
        this.refund = refund;
    }

    public BigDecimal getIncomeratio() {
        return incomeratio;
    }

    public void setIncomeratio(BigDecimal incomeratio) {
        this.incomeratio = incomeratio;
    }

    public String getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(String orderstate) {
        this.orderstate = orderstate == null ? null : orderstate.trim();
    }

    public String getDeliverynum() {
        return deliverynum;
    }

    public void setDeliverynum(String deliverynum) {
        this.deliverynum = deliverynum == null ? null : deliverynum.trim();
    }

    public Long getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(Long deliverydate) {
        this.deliverydate = deliverydate;
    }

    public Long getRecipdate() {
        return recipdate;
    }

    public void setRecipdate(Long recipdate) {
        this.recipdate = recipdate;
    }

    public Long getPlatformdate() {
        return platformdate;
    }

    public void setPlatformdate(Long platformdate) {
        this.platformdate = platformdate;
    }

    public Long getCompletedate() {
        return completedate;
    }

    public void setCompletedate(Long completedate) {
        this.completedate = completedate;
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

    public Integer getGoods() {
        return goods;
    }

    public void setGoods(Integer goods) {
        this.goods = goods;
    }

    public String getDatagoods() {
        return datagoods;
    }

    public void setDatagoods(String datagoods) {
        this.datagoods = datagoods == null ? null : datagoods.trim();
    }
}