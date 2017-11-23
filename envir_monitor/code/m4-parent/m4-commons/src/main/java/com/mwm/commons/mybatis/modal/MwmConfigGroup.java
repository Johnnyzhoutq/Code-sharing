package com.mwm.commons.mybatis.modal;

public class MwmConfigGroup {
    private Integer groupId;

    private String name;

    private String description;

    private Integer forUser;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getForUser() {
        return forUser;
    }

    public void setForUser(Integer forUser) {
        this.forUser = forUser;
    }
}