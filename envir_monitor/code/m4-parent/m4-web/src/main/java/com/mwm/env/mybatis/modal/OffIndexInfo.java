package com.mwm.env.mybatis.modal;

import java.math.BigDecimal;

public class OffIndexInfo {
    private Integer offindexid;

    private Integer offindexlibid;

    private String offindexname;

    private String offindexunits;

    private BigDecimal offindexprice;

    private Long createdate;

    private Long modifydate;

    public Integer getOffindexid() {
        return offindexid;
    }

    public void setOffindexid(Integer offindexid) {
        this.offindexid = offindexid;
    }

    public Integer getOffindexlibid() {
        return offindexlibid;
    }

    public void setOffindexlibid(Integer offindexlibid) {
        this.offindexlibid = offindexlibid;
    }

    public String getOffindexname() {
        return offindexname;
    }

    public void setOffindexname(String offindexname) {
        this.offindexname = offindexname == null ? null : offindexname.trim();
    }

    public String getOffindexunits() {
        return offindexunits;
    }

    public void setOffindexunits(String offindexunits) {
        this.offindexunits = offindexunits == null ? null : offindexunits.trim();
    }

    public BigDecimal getOffindexprice() {
        return offindexprice;
    }

    public void setOffindexprice(BigDecimal offindexprice) {
        this.offindexprice = offindexprice;
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