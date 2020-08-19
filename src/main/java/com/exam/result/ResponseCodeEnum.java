package com.exam.result;

import lombok.Getter;

/**
 * @date Created on 2018/4/19 9:33
 * @function: 返回请求码值
 */
@Getter
public enum ResponseCodeEnum {


    SUCCESS(200,"SUCCESS"),//成功返回

    LOGINSUCCESS(201,"登陆成功"),

    EXCEPTION(500,"出现异常"),//出现异常

    TOKEN_TIMEOUT(401,"登陆过期，请重新登陆"),//token过期

    QU_ERROR(402,"输入参数错误"),//token过期

    ERROR(400,"网络请求出错");//失败返回


    private final int code;
    private final String desc;

    ResponseCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
