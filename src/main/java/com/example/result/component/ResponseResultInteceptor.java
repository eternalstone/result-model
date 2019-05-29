package com.example.result.component;

import com.example.result.annotation.ResponseResult;
import com.example.result.model.Constant;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Author lijiangzhou
 * @Date 2019/5/29  14:02
 * @ClassName: ResponseResultInteceptor
 * @Description: 拦截请求，获取ResponseResult注解的方法包装返回对象
 */
@Component
public class ResponseResultInteceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler instanceof HandlerMethod){
            //TODO 反射获取效率较低，可适当做缓存
            final HandlerMethod handlerMethod = (HandlerMethod)handler;
            final Class<?> clazz = handlerMethod.getBeanType();
            final Method method = handlerMethod.getMethod();

            //该执行方法的类上有注解 或 该执行方法上有注解
            if(clazz.isAnnotationPresent(ResponseResult.class) ){
                request.setAttribute(Constant.RESPONSE_RESULT_ANN,clazz.getAnnotation(ResponseResult.class));
            }else if(method.isAnnotationPresent(ResponseResult.class)){
                request.setAttribute(Constant.RESPONSE_RESULT_ANN,method.getAnnotation(ResponseResult.class));
            }

        }
        return true;
    }
}
