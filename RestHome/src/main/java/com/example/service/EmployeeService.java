package com.example.service;

import com.example.entity.Employee;
import com.example.repo.EmployeeCrudRepository;
import com.example.repo.EmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final ObjectMapper objectMapper;
    private final EmployeeCrudRepository employeeCrudRepository;
    private final EmployeeRepository employeeRepository;


    @Transactional
    public Employee saveEmployee(Employee employee){
        employeeRepository.save(employee);
        return employee;
    }

    public Optional<Employee> getEmployeeById(int id){
        return employeeRepository.findById(id);
    }
    @Transactional
    public void deleteEmployee(int id){
         employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(Employee employee){
        return employeeCrudRepository.save(employee);
    }
}
