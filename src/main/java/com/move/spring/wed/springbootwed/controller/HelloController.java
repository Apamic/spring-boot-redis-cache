package com.move.spring.wed.springbootwed.controller;

import com.move.spring.wed.springbootwed.bean.Employee;
import com.move.spring.wed.springbootwed.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


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


    @GetMapping("/deleteemp")
    public String deleteEmp(Integer id) {
        employeeService.deleteEmp(id);
        return "success";
    }


    @GetMapping("/getEmpByLastName/{lastName}")
    public List<Employee> getEmpByLastName(@PathVariable("lastName") String lastName) {
        List<Employee> empByLastName = employeeService.getEmpByLastName(lastName);
        return empByLastName;
    }
}
