package com.mwm.env.mybatis.modal;

public class GrantInfo {
    private Byte grantid;

    private String grantlevel;

    private Long createdate;

    private Long modifydate;

    private String grantcontent;

    public Byte getGrantid() {
        return grantid;
    }

    public void setGrantid(Byte grantid) {
        this.grantid = grantid;
    }

    public String getGrantlevel() {
        return grantlevel;
    }

    public void setGrantlevel(String grantlevel) {
        this.grantlevel = grantlevel == null ? null : grantlevel.trim();
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

    public String getGrantcontent() {
        return grantcontent;
    }

    public void setGrantcontent(String grantcontent) {
        this.grantcontent = grantcontent == null ? null : grantcontent.trim();
    }
}