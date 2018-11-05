package com.move.spring.wed.springbootwed.service;

import com.move.spring.wed.springbootwed.bean.Employee;
import com.move.spring.wed.springbootwed.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 将方法的运行结果进行缓存；以后再要相同的数据，直接从缓存中获取，不用调方法；
     *
     * CacheManager管理多个Cache组件，对于缓存的真正CRUD操作在Cache组件中，每一个缓存组件有自己的唯一一个名字；
     * 属性
     * cacheNames/value 缓存组件的名字
     * key: 缓存数据使用的key
     *     编写SPEL: #id 是参数id的值  #a0 #p0 #root.argr[0]
     * keyGenerator: key组件生成器；可以自己key的生成器的组件ID
     *    keyGenerator/key 二选一
     * cacheManager：指定缓存管理器；或者cacheResolver指定获取解析器
     * condition：指定符合条件下才缓存；
     *        condition = "#a0>1":第一个参数的值 > 1 的时候才进行缓存
     * unless: 否定缓存；当unless指定的条件为TRUE，方法的返回值就不会被缓存；可以获取的结构进行判断
     *    unless = "#result == null"
     *    unless = "#a0 == 2"   如果第一个参数的值是2，结果不缓存
     * sync: 是否使用异步模式
     * @param id
     * @return
     */
    @Cacheable(value = {"emp"}
//    , keyGenerator = "myKeyGenerator", condition = "#a0 > 1", unless = "#a0 == 2"
    )
    public Employee getEmp(Integer id) {
        Employee emp = employeeMapper.selectByPrimaryKey(id);
        return emp;
    }


    /**
     * @CachePut: 既调用方法，又跟新缓存数据；
     * 修改了数据库的某个数据，同时跟新缓存；
     *
     * 运行时机；
     *      1，先调用目标方法
     *      2，将目标方法的结果缓存起来
     */
    @CachePut(cacheNames = {"emp"}, key = "#result.id")
    public Employee updateEmp(Employee employee) {
        System.out.println("updateEmp" + employee);
        employeeMapper.updateByPrimaryKey(employee);
        return employee;
    }
}
