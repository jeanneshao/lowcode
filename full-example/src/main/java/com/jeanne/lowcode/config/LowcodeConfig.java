package com.jeanne.lowcode.config;

import com.jeanne.lowcode.interceptors.access.AccessInterceptor;
import com.jeanne.lowcode.interceptors.query.QueryParamInterceptor;
import com.jeanne.lowcode.interceptors.query.TextSearchArgumentResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Jeanne 2023/5/24
 **/
@Configuration(proxyBeanMethods = true)
@Slf4j
@RestControllerAdvice
public class LowcodeConfig implements WebMvcConfigurer {
    @Resource
    AccessInterceptor accessInterceptor;
    @Autowired
    QueryParamInterceptor queryParamInterceptor;

    @Resource
    TextSearchArgumentResolver textSearchArgumentResolver;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 可添加多个
        registry.addInterceptor(accessInterceptor).addPathPatterns("/**");
        registry.addInterceptor(queryParamInterceptor).addPathPatterns("/**");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers){
        resolvers.add(textSearchArgumentResolver);
    }




}
