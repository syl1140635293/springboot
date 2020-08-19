/**
 * Company
 * Copyright (C) 2019 All Rights Reserved.
 */
package com.exam.controller;

import com.exam.model.type.Type;
import com.exam.result.ServiceResponse;
import com.exam.service.ITypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * @author SYL
 * @date Created on 2019/2/13 15:09
 * @function:
 */
@Slf4j
@RestController
@Api(value="TypeController",description = "类别接口")
@RequestMapping("type")
public class TypeController {

    @Autowired
    private ITypeService mITypeService;

    @ApiOperation(value = "获取类别")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "token", value = "token",required = true),
    })
    @GetMapping("get")
    public ServiceResponse<List> get(){
        return ServiceResponse.createBySuccess(mITypeService.get(new Type()));
    }

    public ServiceResponse<String> add(){


        return ServiceResponse.createBySuccess("添加成功");
    }
}
