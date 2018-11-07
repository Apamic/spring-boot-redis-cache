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
 *  3，配置redis
 *  4, 测试缓存
 *      原理：CacheManager === Cache 缓存组件来实际给缓存中存取数据
 *      1）,引入redis的starter,容器中保存的是 RedisCacheManager;
 *      2），RedisCacheManager 帮我们创建 RedisCache 来作为缓存组件；RedisCache通过操作redis缓存数据的
 *      3），默认保存数据 k－ｖ都是object;利用序列化保存；如何保存为json.
 *               1 引入redis的starter,cacheManager变为 RedisCacheManager；
 *               2 默认创建的 RedisCacheManager 操作redis的时候使用的是RedisTemplate<object,object>
 *               3 RedisTemplate<object,object> 是默认使用的ＪＤＫ的序列化机
 *      ４），自定义CacheManager
 */
@EnableCaching
public class SpringBootWedApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWedApplication.class, args);
    }

}
