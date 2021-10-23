package com.example.rosegoodsbackend.rdbms.config;

import com.example.rosegoodsbackend.rdbms.common.AuthInterceptor;
import com.example.rosegoodsbackend.rdbms.common.UserResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Component
public class CustomizedWebMvcConfiguration implements WebMvcConfigurer {

    List<String> patterns = Arrays.asList(
            "/sys/**",
            "/error"
//            "/wrong/**"
    );


    @Autowired
    private UserResolver userResolver;


    @Autowired
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor).addPathPatterns("/**");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(userResolver);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*");
    }

}