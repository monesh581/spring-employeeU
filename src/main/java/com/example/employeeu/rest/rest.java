package com.example.employeeu.rest;


import com.example.employeeu.emp.employee;
import com.example.employeeu.emp.employeedao;
import com.example.employeeu.service.employeeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class rest {

private employeeservice employeeservice;


    @Autowired
    public rest(com.example.employeeu.service.employeeservice employeeservice) {
        this.employeeservice = employeeservice;
    }

    @GetMapping("/all")
    List<employee> findall(){
      return employeeservice.findall();
    }
    @GetMapping("/all/{id}")
    public employee findEmployeeById(@PathVariable int id) {
        employee emp = employeeservice.findbyid(id);

        if (emp == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }

        return emp;
    }

    @PostMapping("/employee")
    employee add(@RequestBody employee emp){



        employee em=employeeservice.save(emp);
        return  em;

    }

    @PutMapping("/employ")
    employee update(@RequestBody employee emp){
        employee em=employeeservice.save(emp);

        return em;

    }

    @DeleteMapping("/delete/{id}")
    employee delete(@PathVariable int id){
        employee emp=employeeservice.deletebyid(id);
        return emp;
    }

}
