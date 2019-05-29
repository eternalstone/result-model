package com.example.result.component;

import com.example.result.annotation.ResponseResult;
import com.example.result.exception.IException;
import com.example.result.model.Constant;
import com.example.result.model.ResultModel;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author lijiangzhou
 * @Date 2019/5/29  14:17
 * @ClassName: ResponseResultHandler
 * @Description: TODO
 */
@ControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter resultType, Class<? extends HttpMessageConverter<?>> converterType) {
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        ResponseResult result = (ResponseResult)request.getAttribute(Constant.RESPONSE_RESULT_ANN);
        return result == null ? false : true;
    }

    @Nullable
    @Override
    public Object beforeBodyWrite(@Nullable Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        //如果返回的是自定义异常，则抛出失败响应
        if(body instanceof IException){
            IException exception = (IException) body;
            return ResultModel.failure(exception.getCode(),exception.getMessage(),exception.getError());
        }
        return ResultModel.success(body);
    }
}
