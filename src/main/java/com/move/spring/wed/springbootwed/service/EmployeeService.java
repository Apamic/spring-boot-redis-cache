package com.move.spring.wed.springbootwed.service;

import com.move.spring.wed.springbootwed.bean.Employee;
import com.move.spring.wed.springbootwed.bean.EmployeeExample;
import com.move.spring.wed.springbootwed.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

@CacheConfig(cacheNames = "emp") //抽取缓存的公共配置
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

    /**
     * @CacheEvict: 清除缓存
     *  key: 指定要清除的数据
     *  allEntries = true 清除缓存中所有的数据
     *  beforeInvocation = false 缓存的清除是在方法执行之后，方法出现异常不会清除缓存
     *  beforeInvocation = true 缓存的清除是在方法执行之前，无论方法出现异常，缓存都会清除
     * @param id
     */
    @CacheEvict(value = "emp", /*key = "#id"*/allEntries = true,beforeInvocation = true)
    public void deleteEmp(Integer id) {
        System.out.println("deleteEmp" + id);
//        employeeMapper.deleteByPrimaryKey(id);
//        int i = 10/0;
    }


//    public List<Employee> getEmpByLastName() {
//        //封装员工查询条件的example
//        EmployeeExample example = new EmployeeExample();
//        EmployeeExample.Criteria criteria = example.createCriteria();
//        criteria.andLastnameLike("王磊");
//        criteria.andGenderEqualTo(1);
//        EmployeeExample.Criteria criteria2 = example.createCriteria();
//        criteria2.andEmailLike("%w%");
//        //拼装或 or
//        example.or(criteria2);
//        System.out.println(example);
//        List<Employee> employeeList = employeeMapper.selectByExample(example);
//        return employeeList;
//    }


    /**
     * @Caching: 定义复杂的缓存规则
     * @param lastName
     * @return
     */

    @Caching(
        cacheable = {
               @Cacheable(/*value = "emp",*/key = "#lastName")
        }
//        ,
//        put = {
//                @CachePut(value = "emp",key = "#result.id"),
//                @CachePut(value = "emp",key = "#result.email")
//        }
    )
    public List<Employee> getEmpByLastName(String lastName) {
        System.out.println(lastName);
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andLastnameLike(lastName);
        return employeeMapper.selectByExample(example);
    }


}
