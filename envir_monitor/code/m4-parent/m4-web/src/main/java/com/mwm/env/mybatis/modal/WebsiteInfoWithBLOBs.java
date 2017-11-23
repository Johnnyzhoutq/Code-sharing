package com.mwm.env.mybatis.modal;

public class WebsiteInfoWithBLOBs extends WebsiteInfo {
    private String description;

    private String paramestersettings;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getParamestersettings() {
        return paramestersettings;
    }

    public void setParamestersettings(String paramestersettings) {
        this.paramestersettings = paramestersettings == null ? null : paramestersettings.trim();
    }
}