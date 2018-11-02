package com.move.spring.wed.springbootwed.controller;

import com.move.spring.wed.springbootwed.bean.Department;
import com.move.spring.wed.springbootwed.dao.DepartmentMapper;
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
    DepartmentMapper departmentMapper;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/departmentMapper/{id}")
    public Department getDepartment(@PathVariable("id") Integer id) {
        return departmentMapper.selectByPrimaryKey(id);
    }

}
