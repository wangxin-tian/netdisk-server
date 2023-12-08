package com.dhx.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

import java.sql.Timestamp;
import java.util.Arrays;

@TableName(value = "user")
public class User {
    public  String token;
    private String id;
    private String username;
    private String password;
    private Timestamp createTime;
    private byte[] avator;
    private String userinfo;

    // 省略getter和setter方法

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public byte[] getAvator() {
        return avator;
    }

    public void setAvator(byte[] avator) {
        this.avator = avator;
    }

    public String getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(String userinfo) {
        this.userinfo = userinfo;
    }

    @Override
    public String toString() {
        return "User{" +
                "token='" + token + '\'' +
                ", id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                ", avator=" + Arrays.toString(avator) +
                ", userinfo='" + userinfo + '\'' +
                '}';
    }
}