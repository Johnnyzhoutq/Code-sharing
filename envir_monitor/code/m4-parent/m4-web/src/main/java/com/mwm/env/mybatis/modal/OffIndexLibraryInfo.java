package com.mwm.env.mybatis.modal;

public class OffIndexLibraryInfo {
    private Integer offindexlibid;

    private String offindexlibname;

    private Long createdate;

    private Long modifydate;

    private String offindexlibdes;

    public Integer getOffindexlibid() {
        return offindexlibid;
    }

    public void setOffindexlibid(Integer offindexlibid) {
        this.offindexlibid = offindexlibid;
    }

    public String getOffindexlibname() {
        return offindexlibname;
    }

    public void setOffindexlibname(String offindexlibname) {
        this.offindexlibname = offindexlibname == null ? null : offindexlibname.trim();
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

    public String getOffindexlibdes() {
        return offindexlibdes;
    }

    public void setOffindexlibdes(String offindexlibdes) {
        this.offindexlibdes = offindexlibdes == null ? null : offindexlibdes.trim();
    }
}