/**
 * Company
 * Copyright (C) 2019 All Rights Reserved.
 */
package com.exam.controller;

import com.exam.redis.RedisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

/**
 * @author SYL
 * @date Created on 2019/2/12 11:38
 * @function:
 */
@Slf4j
public class BaseController {

    @Autowired
    protected RedisService mRedisService;

    /**
     * 获取请求文件的request
     *
     * @return
     */
    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    /**
     * 获取请求头
     *
     * @return
     */
    protected String getHeadersToken() {
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = req.getHeader("token");
        return token;
    }

}
