/**
 * Company
 * Copyright (C) 2019 All Rights Reserved.
 */
package com.exam.service.impl;

import com.exam.dao.TypeDao;
import com.exam.model.type.Type;
import com.exam.service.ITypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SYL
 * @date Created on 2019/2/13 15:08
 * @function:
 */
@Service
public class TypeService implements ITypeService {

    @Autowired
    private TypeDao mTypeDao;

    @Override
    public int insert(Type record) {
        return 0;
    }

    @Override
    public int update(Type record) {
        return 0;
    }

    @Override
    public List<Type> get(Type type) {
        return mTypeDao.get(type);
    }
}
