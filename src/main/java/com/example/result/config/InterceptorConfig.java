package com.example.result.config;

import com.example.result.component.ResponseResultInteceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author lijiangzhou
 * @Date 2019/5/29  14:26
 * @ClassName: InterceptorConfig
 * @Description: TODO
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Autowired
    private ResponseResultInteceptor responseResultInteceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(responseResultInteceptor)
                .addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
