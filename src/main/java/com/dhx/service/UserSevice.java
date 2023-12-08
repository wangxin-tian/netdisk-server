package com.dhx.service;

import com.dhx.pojo.User;

import java.util.List;

public interface UserSevice {
    void addUser(String username, String password);
    void updateAvator(byte[] avator, long id);
    void updateUserInfo(String userinfo, long id);
    User getUser(String username, String password);
    User getUserById(String id);
    List<User> getAllUsers();
}
