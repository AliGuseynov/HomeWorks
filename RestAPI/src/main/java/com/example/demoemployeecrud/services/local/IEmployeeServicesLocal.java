package com.example.demoemployeecrud.services.local;

import com.example.demoemployeecrud.dto.EmployeeDTO;
import com.example.demoemployeecrud.entities.EmployeeEntity;

import java.util.List;
import java.util.Optional;

public interface IEmployeeServicesLocal {
    List<EmployeeEntity> getAllEmployee();

    EmployeeEntity getById(long id);

    void delete(long id);

    EmployeeEntity update(EmployeeEntity employeeEntity);


    List<EmployeeEntity> search(String name, int page, int size);

    EmployeeEntity save(EmployeeEntity employeeEntity);
}
