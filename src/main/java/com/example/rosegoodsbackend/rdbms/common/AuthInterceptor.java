package com.example.rosegoodsbackend.rdbms.common;

import com.example.rosegoodsbackend.rdbms.error.GeneralException;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("Authorization");

        if (token == null) {
            throw GeneralException.ofNullTokenException();
        }
        try {
            // Token is examined but not examined for information here
            Jwts.parser().setSigningKey("MG9BRHIp75bvtGtc8qug".getBytes()).parseClaimsJws(token);
        } catch (Exception e) {
            throw GeneralException.ofInvalidTokenException();
        }

        return true;
    }



    /*@Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

    private void setReturn(HttpServletResponse response, String message) throws IOException {
        response.setHeader("Access-Control-Allow-Credentials", "true");
        //UTF-8 Encoding
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        Result failResult = Result.fail(message);
        String json = JSON.toJSONString(failResult);
        response.getWriter().print(json);
    }*/
}