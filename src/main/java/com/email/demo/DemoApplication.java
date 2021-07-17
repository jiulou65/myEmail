package com.email.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.email.demo.dao")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("gogogo");
        System.out.println("gogogo");
        System.out.println("gogogo");
        System.out.println("gogogo");
         System.out.println("gogogo");
        System.out.println("gogogo");
    }

}
