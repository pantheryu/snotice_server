package com.kevin.model;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by spirit on 2015/10/2.
 */
@Component
public class User {
    private int id;
    private int state;
    private String nickname;
    private String password;
    private String token;
    private Date tokenTime;
    private String username;
    private String aliasname;
    private String picPath;
    private int sex;        //0Å® 1ÄÐ
    private String signature;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getTokenTime() {
        return tokenTime;
    }

    public void setTokenTime(Date tokenTime) {
        this.tokenTime = tokenTime;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAliasname() {
        return aliasname;
    }

    public void setAliasname(String aliasname) {
        this.aliasname = aliasname;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
