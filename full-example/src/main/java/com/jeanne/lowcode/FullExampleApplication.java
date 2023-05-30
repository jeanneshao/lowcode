package com.jeanne.lowcode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Jeanne 2023/5/22
 **/
@SpringBootApplication
@Configuration
public class FullExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(FullExampleApplication.class, args);
    }

}
