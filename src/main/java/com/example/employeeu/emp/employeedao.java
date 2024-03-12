package com.example.employeeu.emp;

import java.util.List;

public interface employeedao {

    List<employee> findall();

     employee findbyid(int id);

     employee save(employee employee);


     void deletebyid(int id);
}
