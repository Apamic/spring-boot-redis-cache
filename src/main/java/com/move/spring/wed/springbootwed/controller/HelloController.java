package com.move.spring.wed.springbootwed.controller;

import com.move.spring.wed.springbootwed.bean.Department;
import com.move.spring.wed.springbootwed.bean.Employee;
import com.move.spring.wed.springbootwed.dao.DepartmentMapper;
import com.move.spring.wed.springbootwed.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class HelloController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id) {
        System.out.println("员工ID" + id);
        Employee employee = employeeService.getEmp(id);
        return employee;
    }

    @GetMapping("/emp")
    public Employee update(Employee employee) {
        Employee emp = employeeService.updateEmp(employee);
        return emp;
    }
}
