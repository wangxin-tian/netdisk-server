package com.dhx.service.impl;

import com.dhx.mapper.UserMapper;
import com.dhx.pojo.User;
import com.dhx.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMapperImpl implements UserSevice {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(String username, String password) {
        userMapper.addUser(username, password);
    }

    @Override
    public void updateAvator(byte[] avator, long id) {
        userMapper.updateAvator(avator, id);
    }

    @Override
    public void updateUserInfo(String userinfo, long id) {
        userMapper.updateUserInfo(userinfo, id);
    }

    @Override
    public User getUser(String username, String password) {
        return userMapper.getUser(username, password);
    }

    @Override
    public User getUserById(String id) {
        return userMapper.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }
}
