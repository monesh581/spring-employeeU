package com.example.employeeu.service;

import com.example.employeeu.emp.employee;

import java.util.List;

public interface employeeservice {

    List<employee> findall();

    employee findbyid(int id);

    employee deletebyid(int id);

    employee save(employee employee);

}
