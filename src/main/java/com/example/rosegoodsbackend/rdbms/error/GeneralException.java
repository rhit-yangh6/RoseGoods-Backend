package com.example.rosegoodsbackend.rdbms.error;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GeneralException extends RuntimeException{
    public GeneralException(String message) {
        super(message);
    }

    public static GeneralException ofInvalidTokenException(){
        log.info("Invalid token.");
        return new GeneralException("Token is invalid.");
    }

    public static GeneralException ofNullTokenException() {
        log.info("No token header found.");
        return new GeneralException("Token is null.");
    }

    public static Exception ofNullUserException(String invalidUsername) {
        log.info("Invalid user: " + invalidUsername);
        return new GeneralException("Invalid user: " + invalidUsername);
    }
}