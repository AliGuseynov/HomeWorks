package com.example.demoemployeecrud.services;

import com.example.demoemployeecrud.dto.EmployeeDTO;

import java.util.List;
import java.util.Optional;

public interface IEmployeeServices {
    List<EmployeeDTO> getAllEmployee();

    EmployeeDTO getById(long id);

    List<EmployeeDTO> delete(long id);

    Optional<Object> update(EmployeeDTO employeeDTO);

//    void add(EmployeeDTO employeeDTO);

    List<EmployeeDTO> search(String name, String sortType);

    EmployeeDTO save(EmployeeDTO employeeDTO);
}
