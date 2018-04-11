package com.netcracker.unc.dao;

import com.netcracker.unc.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {

    @Select("select * from users where user_id = #{id}")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name")
    })
    User getUserById(Integer id);

    @Select("select * from users where username = #{username}")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name")
    })
    User getUserByUsername(String username);

    @Select("select * from users")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name")
    })
    List<User> getAllUsers();

    @Insert("insert into users(first_name, last_name, username, password) values(#{firstName}, #{lastName}, #{username}, #{password}) ")
    void addUser(User user);

    @Update("update users set first_name=#{firstName}, last_name=#{lastName}, username=#{username} where user_id=#{userId}")
    void updateUser(User user);

    @Delete("delete from users where user_id=#{id}")
    void deleteUser(Integer id);
}
