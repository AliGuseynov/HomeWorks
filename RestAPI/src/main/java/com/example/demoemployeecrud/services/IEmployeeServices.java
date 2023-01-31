package com.example.demoemployeecrud.services;

import com.example.demoemployeecrud.dto.EmployeeDTO;

import java.util.List;
import java.util.Optional;

public interface IEmployeeServices {
    void getAllEmployee();

    EmployeeDTO getById(long id);

    List<EmployeeDTO> delete(long id);

    void update(long id, EmployeeDTO employeeDTO);

//    void add(EmployeeDTO employeeDTO);

    List<EmployeeDTO> search(String name, String sortType);

    void save(EmployeeDTO employeeDTO);
}
