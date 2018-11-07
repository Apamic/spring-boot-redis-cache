package com.move.spring.wed.springbootwed.config;

import com.move.spring.wed.springbootwed.bean.Employee;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

@Configuration
public class MyRedisConfig {
    @Bean
//    @ConditionalOnMissingBean(
//            name = {"redisTemplate"}
//    )
    public RedisTemplate<Object, Employee> employeeRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Employee> template = new RedisTemplate<Object, Employee>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Employee> employeeJackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Employee>(Employee.class);
        template.setDefaultSerializer(employeeJackson2JsonRedisSerializer);
        return template;
    }

//    @Bean
//    public RedisCacheManager employeeCacheManager(RedisTemplate<Object, Employee> employeeRedisTemplate) {
//        RedisCacheManager cacheManager = new RedisCacheManager(employeeRedisTemplate);
//        cacheManager.setUsePrefix(true);
//    }
}
