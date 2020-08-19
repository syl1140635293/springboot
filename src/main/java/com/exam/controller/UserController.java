/**
 * Company
 * Copyright (C) 2019 All Rights Reserved.
 */
package com.exam.controller;

import com.exam.model.user.User;
import com.exam.redis.RedisService;
import com.exam.result.ServiceResponse;
import com.exam.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @author SYL
 * @date Created on 2019/2/13 11:00
 * @function:
 */
@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService mIUserService;

    @Autowired
    private RedisService redisService;

    @GetMapping("test")
    public String TestRedis(){

        for (int i = 0; i < 5000; i++) {
            String key = "spring-key"+i;
            redisService.save("spring-key1","12312");
        }

        return "成功";
    }

    @GetMapping("getRedis")
    public String getTestRedis(){
        String byKey = redisService.getByKey("spring-key1");
        return byKey;
    }

    @GetMapping("get")
    public ServiceResponse<List> get(){
        return ServiceResponse.createBySuccess(mIUserService.get(new User()));
    }
}
