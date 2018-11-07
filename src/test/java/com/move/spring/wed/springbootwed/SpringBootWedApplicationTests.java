package com.move.spring.wed.springbootwed;

import com.move.spring.wed.springbootwed.bean.Employee;
import com.move.spring.wed.springbootwed.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootWedApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    DataSource dataSource;

    @Autowired
    RedisTemplate redisTemplate; //k - v 都是对象

    @Autowired
    StringRedisTemplate stringRedisTemplate; //k - v 都字符串

    @Autowired
    RedisTemplate<Object,Employee> employeeRedisTemplate;

    /**
     * redis常见的五大数据类型
     * String (字符串) ，List（列表），Set（集合），Hash（散列），Zset（有序集合）
     * stringRedisTemplate.opsForXXXX 来操作
     */

    @Test
    public void text01() {
//        stringRedisTemplate.opsForValue().append("msg","hello");
        String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(msg);
    }


    //测试保存对象
    @Test
    public void text02() {
        Employee employee = employeeMapper.selectByPrimaryKey(1);
        //默认如果保存对象，使用jdk序列化机制，序列化后的数据保存到redis中
        //redisTemplate.opsForValue().set("emp-01",employee);
        //1,将数据以JOSN的方式保存
        //  (1)自己将对象转为josn
        //  (2)redisTemplate默认的序列化规则
        employeeRedisTemplate.opsForValue().set("emp-01",employee);
    }

    @Test
    public void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());

        Connection connection = dataSource.getConnection();

        System.out.println(connection);

        connection.close();

    }

}
