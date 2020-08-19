package com.exam.dao;

import com.exam.model.user.User;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    int insert(User record);

    int update(User record);

    List<User> get(User user);
}