package com.mwm.env.mybatis.modal;

import java.util.Date;

public class LiveChatMsg {
    private Integer msgid;

    private Integer kefuid;

    private Integer customerid;

    private String flag;

    private Date createdate;

    private String msg;

    public Integer getMsgid() {
        return msgid;
    }

    public void setMsgid(Integer msgid) {
        this.msgid = msgid;
    }

    public Integer getKefuid() {
        return kefuid;
    }

    public void setKefuid(Integer kefuid) {
        this.kefuid = kefuid;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }
}