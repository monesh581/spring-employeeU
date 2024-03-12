package com.example.employeeu.emp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@Repository
public class employeedaoimpl implements employeedao{


   private EntityManager entityManager;


   @Autowired
    public employeedaoimpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<employee> findall() {
        TypedQuery<employee> query= entityManager.createQuery("FROM employee ", employee.class);
        return query.getResultList();
    }

    @Override
    public employee findbyid(int id) {
       employee emp=entityManager.find(employee.class,id);
        return emp;
    }

    @Override
    public employee save(employee employee) {
        employee emp=entityManager.merge(employee);
        return emp;
    }

    @Override
    public void deletebyid(int id) {
        employee emp=entityManager.find(employee.class,id);
        entityManager.remove(emp);
    }
}
