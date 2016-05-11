package com.kevin.model;

import org.springframework.stereotype.Component;

/**
 * Created by spirit on 2016/2/24.
 */
@Component
public class UserInfo {
    private int userId;
    private String name;
    private int sex;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
