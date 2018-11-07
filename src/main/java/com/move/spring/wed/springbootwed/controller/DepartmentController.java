package com.move.spring.wed.springbootwed.controller;


import com.move.spring.wed.springbootwed.bean.Department;
import com.move.spring.wed.springbootwed.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    DeptService deptService;
    
    @GetMapping("/dept/{id}")
    public Department getDept(@PathVariable("id") Integer id) {
        return deptService.getDeptById(id);
    }
}
