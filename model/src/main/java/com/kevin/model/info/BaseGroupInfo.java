package com.kevin.model.info;

/**
 * Created by spirit on 2016/3/4.
 */
public class BaseGroupInfo {
    private int id;
    private String name;
    private String description;
    private int memberNums;
    private String picPath;

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMemberNums() {
        return memberNums;
    }

    public void setMemberNums(int memberNums) {
        this.memberNums = memberNums;
    }
}
