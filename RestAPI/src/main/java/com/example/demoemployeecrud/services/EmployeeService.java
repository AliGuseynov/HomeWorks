package com.example.demoemployeecrud.services;

import com.example.demoemployeecrud.entities.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    List<EmployeeEntity> getAllEmployee();

    EmployeeEntity getById(long id);

    void delete(long id);

    List<EmployeeEntity> search(String name, Integer page, Integer size);

    EmployeeEntity save(EmployeeEntity employeeEntity);
}
