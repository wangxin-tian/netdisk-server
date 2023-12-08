package com.dhx.mapper;

import com.dhx.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("insert into user (username,password) values (#{username}, #{password}})")
    void addUser(String username, String password);

    @Update("update user set avator=#{avator} where id=#{id}}")
    void updateAvator(byte[] avator, long id);

    @Update("update user set userinfo=#{userinfo} where id=#{id}}")
    void updateUserInfo(String userinfo, long id);

    @Select("select * from user where username=#{username} and password=#{password}")
    User getUser(String username, String password);

    @Select("select * from user")
    List<User> getAllUsers();

    @Select("select * from user where id=#{ud}")
    User getUserById(String id);
}