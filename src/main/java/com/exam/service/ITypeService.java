/**
 * Company
 * Copyright (C) 2019 All Rights Reserved.
 */
package com.exam.service;

import com.exam.model.type.Type;

import java.util.List;

/**
 * @author SYL
 * @date Created on 2019/2/13 15:07
 * @function:
 */
public interface ITypeService {
    int insert(Type record);

    int update(Type record);

    List<Type> get(Type type);
}
