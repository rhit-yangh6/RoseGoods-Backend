package com.example.rosegoodsbackend.rdbms.error;

import com.example.rosegoodsbackend.rdbms.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionController {

    @ExceptionHandler(value = GeneralException.class)
    public Result<?> generalExceptionHandler(Exception e){
        log.info(e.getMessage(), e.getCause());
        return Result.fail(e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public Result<?> exceptionHandler(Exception e){
        log.error(e.getMessage(), e.getCause());
        e.printStackTrace();
        return Result.fail("Unknown Error.");
    }

}