package com.example.result.exception;

import com.example.result.model.ResultCode;

/**
 * @Author lijiangzhou
 * @Date 2019/5/29  15:20
 * @ClassName: UnknownException
 * @Description: 未知异常
 */
public class UnknownException extends IException{

    public UnknownException(Object error) {
        super(ResultCode.UNKNOWN_ERROR.code(), ResultCode.UNKNOWN_ERROR.message(),error);
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }
}
