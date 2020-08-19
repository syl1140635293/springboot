package com.exam.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServiceResponse<T> implements Serializable {

    private String message;
    private int code;
    private T data;

    private ServiceResponse(int code){
        this.code = code;
    }
    private ServiceResponse(int code,T data){
        this.code = code;
        this.data = data;
    }
    private ServiceResponse(int code,String message){
        this.code = code;
        this.message = message;
    }
    private ServiceResponse(int code,String message,T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }


    @JsonIgnore
    public boolean isSuccesss(){
        return this.code == ResponseCodeEnum.SUCCESS.getCode();
    }

    public static <T> ServiceResponse<T> createBySuccess(){
        return new ServiceResponse<T>(ResponseCodeEnum.SUCCESS.getCode());
    }
    public static <T> ServiceResponse<T> createBySuccess(String message){
        return new ServiceResponse<T>(ResponseCodeEnum.SUCCESS.getCode(), message);
    }
    public static <T> ServiceResponse<T> createBySuccess(int code, String message){
        return new ServiceResponse<T>(code, message);
    }
    public static <T> ServiceResponse<T> createBySuccess(T data){
        return new ServiceResponse<T>(ResponseCodeEnum.SUCCESS.getCode(), data);
    }

    public static <T> ServiceResponse<T> createBySuccess(String msg, T data){
        return new ServiceResponse<T>(ResponseCodeEnum.SUCCESS.getCode(), msg, data);
    }
    public static <T> ServiceResponse<T> createByError(String msg){
        return new ServiceResponse<T>(ResponseCodeEnum.ERROR.getCode(),msg);
    }
    public static <T> ServiceResponse<T> createByError(int code,String msg){
        return new ServiceResponse<T>(code,msg);
    }

    public static <T> ServiceResponse<T> createByTokenError(){
        return new ServiceResponse<T>(ResponseCodeEnum.TOKEN_TIMEOUT.getCode(),ResponseCodeEnum.TOKEN_TIMEOUT.getDesc());
    }
    public static <T> ServiceResponse<T> createByQueryError(){
        return new ServiceResponse<T>(ResponseCodeEnum.QU_ERROR.getCode(),ResponseCodeEnum.QU_ERROR.getDesc());
    }
    public static <T> ServiceResponse<T> createByException(String msg){
        return new ServiceResponse<T>(ResponseCodeEnum.EXCEPTION.getCode(),msg);
    }

}
