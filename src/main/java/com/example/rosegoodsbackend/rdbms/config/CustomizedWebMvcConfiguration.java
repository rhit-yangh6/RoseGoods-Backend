package com.example.rosegoodsbackend.rdbms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Component
public class CustomizedWebMvcConfiguration implements WebMvcConfigurer {

    List<String> patterns = Arrays.asList(
            "/sys/**",
            "/error"
//            "/wrong/**"
    );


    /*@Autowired
    private UserAccountResolver userAccountResolver;*/

    /*@Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(userAccountResolver);
    }*/


    @Autowired
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor).addPathPatterns("/**");
    }


}