package com.mwm.env.mybatis.modal;

import java.math.BigDecimal;

public class IndexInfo {
    private Integer indexid;

    private Integer provideid;

    private Integer indexlibid;

    private String indexname;

    private String indexunits;

    private BigDecimal indexprice;

    private Integer offindexid;

    private Long createdate;

    private Long modifydate;

    private String state;

    private String indexremark;

    public Integer getIndexid() {
        return indexid;
    }

    public void setIndexid(Integer indexid) {
        this.indexid = indexid;
    }

    public Integer getProvideid() {
        return provideid;
    }

    public void setProvideid(Integer provideid) {
        this.provideid = provideid;
    }

    public Integer getIndexlibid() {
        return indexlibid;
    }

    public void setIndexlibid(Integer indexlibid) {
        this.indexlibid = indexlibid;
    }

    public String getIndexname() {
        return indexname;
    }

    public void setIndexname(String indexname) {
        this.indexname = indexname == null ? null : indexname.trim();
    }

    public String getIndexunits() {
        return indexunits;
    }

    public void setIndexunits(String indexunits) {
        this.indexunits = indexunits == null ? null : indexunits.trim();
    }

    public BigDecimal getIndexprice() {
        return indexprice;
    }

    public void setIndexprice(BigDecimal indexprice) {
        this.indexprice = indexprice;
    }

    public Integer getOffindexid() {
        return offindexid;
    }

    public void setOffindexid(Integer offindexid) {
        this.offindexid = offindexid;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getIndexremark() {
        return indexremark;
    }

    public void setIndexremark(String indexremark) {
        this.indexremark = indexremark == null ? null : indexremark.trim();
    }
}