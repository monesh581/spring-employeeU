package com.example.employeeu.service;

import com.example.employeeu.emp.employee;
import com.example.employeeu.emp.employeedao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class employeeserviceimpl implements employeeservice{

    private employeedao employeedao;


    @Autowired
    public employeeserviceimpl(com.example.employeeu.emp.employeedao employeedao) {
        this.employeedao = employeedao;
    }

    @Override
    public List<employee> findall() {
        return employeedao.findall();
    }

    @Override
    public employee findbyid(int id) {
        return employeedao.findbyid(id);
    }

    @Override
    @Transactional
    public employee deletebyid(int id) {
        employeedao.deletebyid(id);
        return null;
    }

    @Override
    @Transactional
    public employee save(employee employee) {
        return employeedao.save(employee);
    }
}
