package com.move.spring.wed.springbootwed;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan(value = "com.move.spring.wed.springbootwed.dao")
@SpringBootApplication

//bean路径
//@ComponentScan(basePackages = {"com.move.spring.wed.springbootwed.bean"})

/**
 * 开启基于注解的缓存 @EnableCaching
 * 标注缓存注解
 * @Cacheable
 * @CacheEvict
 * @CachePut
 */
@EnableCaching
public class SpringBootWedApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWedApplication.class, args);
    }
}
