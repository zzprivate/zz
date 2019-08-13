package com.nplat.convert.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Resource AppInterceptor appInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(appInterceptor).addPathPatterns("/**").excludePathPatterns("/user/code2Session").excludePathPatterns("/error/01");
    }
}
