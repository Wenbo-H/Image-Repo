package com.wenbo.imagerepo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@MapperScan("com.wenbo.imagerepo.db.mappers")
@ComponentScan(basePackages = {"com.wenbo"})
public class ImagerepoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImagerepoApplication.class, args);
    }

}
