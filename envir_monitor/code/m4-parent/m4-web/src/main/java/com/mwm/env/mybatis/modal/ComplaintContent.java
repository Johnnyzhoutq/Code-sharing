package com.mwm.env.mybatis.modal;

public class ComplaintContent {
    private Integer contentid;

    private String serviceserial;

    private Integer orderid;

    private Integer userid;

    private String username;

    private String usertype;

    private String accepttype;

    private Byte serviceid;

    private String charrecord;

    private Long createdate;

    private Long modifydate;

    public Integer getContentid() {
        return contentid;
    }

    public void setContentid(Integer contentid) {
        this.contentid = contentid;
    }

    public String getServiceserial() {
        return serviceserial;
    }

    public void setServiceserial(String serviceserial) {
        this.serviceserial = serviceserial == null ? null : serviceserial.trim();
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype == null ? null : usertype.trim();
    }

    public String getAccepttype() {
        return accepttype;
    }

    public void setAccepttype(String accepttype) {
        this.accepttype = accepttype == null ? null : accepttype.trim();
    }

    public Byte getServiceid() {
        return serviceid;
    }

    public void setServiceid(Byte serviceid) {
        this.serviceid = serviceid;
    }

    public String getCharrecord() {
        return charrecord;
    }

    public void setCharrecord(String charrecord) {
        this.charrecord = charrecord == null ? null : charrecord.trim();
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