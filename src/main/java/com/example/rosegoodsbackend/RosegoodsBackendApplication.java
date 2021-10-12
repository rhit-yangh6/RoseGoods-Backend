package com.example.rosegoodsbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.rosegoodsbackend.rdbms.mapper")
public class RosegoodsBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(RosegoodsBackendApplication.class, args);
        
    }

}
