/**
 * Company
 * Copyright (C) 2019 All Rights Reserved.
 */
package com.exam.service.impl;

import com.exam.dao.UserDao;
import com.exam.model.user.User;
import com.exam.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @author SYL
 * @date Created on 2019/2/13 10:59
 * @function:
 */
@Service
@Slf4j
public class UserService implements IUserService {

    @Autowired
    private UserDao mUserDao;

    @Override
    public List<User> get(User user) {
        return mUserDao.get(user);
    }
}
