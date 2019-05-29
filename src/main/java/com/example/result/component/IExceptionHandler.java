package com.example.result.component;

import com.example.result.annotation.ResponseResult;
import com.example.result.exception.IException;
import com.example.result.exception.UnknownException;
import com.example.result.model.Constant;
import com.example.result.model.ResultCode;
import com.example.result.model.ResultModel;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author lijiangzhou
 * @Date 2019/5/29  15:11
 * @ClassName: ExceptionHandler
 * @Description: 全局异常处理器：处理统一返回对象与注解返回对象
 */
@ControllerAdvice
public class IExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object errorHandler(Exception ex, HttpServletRequest request,HttpServletResponse response) {
        ResponseResult result = (ResponseResult)request.getAttribute(Constant.RESPONSE_RESULT_ANN);
        if(result != null ){ //通过注解返回
            if (!(ex instanceof IException)) {
                return new UnknownException(ex.getMessage());
            }
            IException exception = (IException) ex;
            return exception;
        }else{
            if (ex instanceof IException) {
                return ResultModel.failure(((IException) ex).getCode(),ex.getMessage(),ex.getMessage());
            } else {
                ex.printStackTrace();
                return ResultModel.failure(ResultCode.UNKNOWN_ERROR.code(),ResultCode.UNKNOWN_ERROR.message(),ex.getMessage());
            }

        }
    }

}
