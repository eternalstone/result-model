package com.example.result.model;

import java.io.Serializable;

/**
 * @Author lijiangzhou
 * @Date 2019/5/29  11:38
 * @ClassName: ResultCode
 * @Description: TODO
 */
public enum ResultCode{

    /**
     * 自定义状态码
     */
    SUCEESS(200,"成功"),
    FAILURE(500,"失败"),
    UNKNOWN_ERROR(9999,"应用程序未知异常");

    public Integer code(){
        return this.code;
    }

    public String message(){
        return this.message;
    }

    /**
     * 基本实体属性
     */
    private Integer code;

    private String message;


    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }





}
