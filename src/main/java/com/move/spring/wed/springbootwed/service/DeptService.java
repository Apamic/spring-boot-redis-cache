package com.move.spring.wed.springbootwed.service;

import com.move.spring.wed.springbootwed.bean.Department;
import com.move.spring.wed.springbootwed.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class DeptService {

    @Autowired
    DepartmentMapper departmentMapper;


    /**
     * 缓存的数据能存入redis;
     * 第2次从缓存中查询就不能反序列化回来；
     * 存的是Dept的json数据;CacheManager默认使用RedisTemplate<object, Employee>默认操作redis
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "dept")
    public Department getDeptById(Integer id) {
        System.out.println("查询部门" + id);
        Department department = departmentMapper.selectByPrimaryKey(id);
        return department;
    }

}
