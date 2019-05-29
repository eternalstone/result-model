package com.example.result.model;

import java.io.Serializable;

/**
 * @Author lijiangzhou
 * @Date 2019/5/29  11:46
 * @ClassName: ResultModel
 * @Description: TODO
 */
public class ResultModel<T> implements Serializable{

    private int code;

    private String message;

    private T data;

    public ResultModel() {

    }

    public ResultModel(ResultCode resultCode, T data) {
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = data;
    }

    public ResultModel(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 通用静态方法
     */
    public static ResultModel success(){
         return new ResultModel(ResultCode.SUCEESS,null);
    }

    public static <T> ResultModel<T> success(T data){
        return new ResultModel(ResultCode.SUCEESS,data);
    }

    public static <T> ResultModel<T> success(String message , T data){
        return new ResultModel(ResultCode.SUCEESS.code(),message,data);
    }

    public static ResultModel failure(){
        return new ResultModel(ResultCode.FAILURE,null);
    }

    public static <T> ResultModel<T> failure(T data){
        return new ResultModel(ResultCode.FAILURE,data);
    }

    public static <T> ResultModel<T> failure(String message , T data){
        return new ResultModel(ResultCode.FAILURE.code(),message, data);
    }

    public static <T> ResultModel<T> failure(int code, String message , T data){
        return new ResultModel(code,message, data);
    }


}
