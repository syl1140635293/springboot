/**
 * Company
 * Copyright (C) 2019 All Rights Reserved.
 */
package com.exam.service;

import com.exam.model.user.User;

import java.util.List;

/**
 * @author SYL
 * @date Created on 2019/2/13 10:58
 * @function:
 */
public interface IUserService {

    List<User> get(User user);
}
