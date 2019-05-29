package com.example.result.exception;

/**
 * @Author lijiangzhou
 * @Date 2019/5/29  15:07
 * @ClassName: IException
 * @Description: 自定义异常基类
 */
public abstract class IException extends RuntimeException {

    public Integer code;

    public Object error;

    public IException() {
    }

    public IException(String message) {
        super(message);
    }

    public IException(Integer code, String message ,Object error) {
        super(message);
        this.code = code;
        this.error = error;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }
}
