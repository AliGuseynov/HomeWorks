package com.example.demoemployeecrud.services.local;

import com.example.demoemployeecrud.dto.EmployeeDTO;
import com.example.demoemployeecrud.entities.EmployeeEntity;
import com.example.demoemployeecrud.repo.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
//@Profile("local")
public class LocalEmployeeService implements IEmployeeServicesLocal {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public LocalEmployeeService(EmployeeRepository employeeRepository) {
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
    public EmployeeEntity update(EmployeeEntity employeeEntity) {
        EmployeeEntity employee = employeeRepository.findById(employeeEntity.getId()).get();
        employee.setName(employeeEntity.getName());
        employee.setSurname(employeeEntity.getSurname());
        employee.setTaskEntities(employeeEntity.getTaskEntities());

        return employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeEntity> search(String name, int page, int size) {
        return employeeRepository.findByName(name, PageRequest.of(page, size, Sort.by(name).ascending()));


    }

    @Override
    public EmployeeEntity save(EmployeeEntity employeeEntity) {
        EmployeeEntity employeeEntity1 = EmployeeEntity.builder().name(employeeEntity.getName())
                .surname(employeeEntity.getSurname())
                .taskEntities(employeeEntity.getTaskEntities()).build();

        return employeeRepository.save(employeeEntity1);

    }
}
