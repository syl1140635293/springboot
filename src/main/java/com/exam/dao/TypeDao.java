package com.exam.dao;

import com.exam.model.type.Type;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TypeDao {

    int insert(Type record);

    int update(Type record);

    List<Type> get(Type type);
}