package com.example.demoemployeecrud.services.impl;

import com.example.demoemployeecrud.entities.EmployeeEntity;
import com.example.demoemployeecrud.repo.EmployeeRepository;
import com.example.demoemployeecrud.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@Profile("prod")
public class DbEmployeeService implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public DbEmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeEntity> getAllEmployee() {

        return employeeRepository.findAll();
    }

    @Override
    public EmployeeEntity getById(long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public void delete(long id) {
        employeeRepository.delete(employeeRepository.findById(id).get());
    }

    @Override
    public List<EmployeeEntity> search(String name, Integer page, Integer size) {
        return employeeRepository.findByName(name, PageRequest.of(page, size, Sort.by(name).ascending()));


    }

    @Override
    public EmployeeEntity save(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);

    }
}
