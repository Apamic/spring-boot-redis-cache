package com.move.spring.wed.springbootwed;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan(value = "com.move.spring.wed.springbootwed.dao")
@SpringBootApplication
//bean路径
//@ComponentScan(basePackages = {"com.move.spring.wed.springbootwed.bean"})

public class SpringBootWedApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWedApplication.class, args);
    }
}
