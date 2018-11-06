package com.move.spring.wed.springbootwed;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan(value = "com.move.spring.wed.springbootwed.mapper")
@SpringBootApplication

//bean路径
//@ComponentScan(basePackages = {"com.move.spring.wed.springbootwed.bean"})

/**
 * 开启基于注解的缓存 @EnableCaching
 * 标注缓存注解
 * @Cacheable
 * @CacheEvict
 * @CachePut
 *
 * 默认使用的是ConcurrentMapCacheManager == ConcurrentMapCache;将数据保存在ConcurrentMap<Object, Object>中
 * 开发中使用的是缓存中间键；redis，memcached, ehcache等等
 *
 * 整合redis作为缓存
 *  1，安装redis:使用docker
 *  2，引入redis的starter
 */
@EnableCaching
public class SpringBootWedApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWedApplication.class, args);
    }
}
