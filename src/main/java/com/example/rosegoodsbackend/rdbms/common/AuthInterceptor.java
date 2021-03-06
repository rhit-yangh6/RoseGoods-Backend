package com.example.rosegoodsbackend.rdbms.common;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if ("OPTIONS".equals(request.getMethod())) {
            return true;
        }

        String token = request.getHeader("Authorization");

        if (token == null) {
            setReturn(response, "No token header found.");
            return false;
        }
        try {
            // Token is examined but not examined for information here
            Jwts.parser().setSigningKey("MG9BRHIp75bvtGtc8qug".getBytes()).parseClaimsJws(token);
        } catch (Exception e) {
            setReturn(response, "Invalid token.");
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

    private void setReturn(HttpServletResponse response, String message) throws IOException {
        //UTF-8 Encoding
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Blackboard-Token");

        Result<Object> failResult = Result.fail(message);
        String json = JSON.toJSONString(failResult);
        response.getWriter().print(json);
    }

}