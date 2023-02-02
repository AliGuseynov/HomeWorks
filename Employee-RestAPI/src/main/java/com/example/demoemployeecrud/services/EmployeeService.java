package com.example.demoemployeecrud.services;

import com.example.demoemployeecrud.entities.EmployeeEntity;
import com.example.demoemployeecrud.entities.TaskEntity;

import java.util.List;

public interface EmployeeService {
    List<EmployeeEntity> getAllEmployee();

    EmployeeEntity getById(long id);

    void delete(long id);

    List<EmployeeEntity> search(String name, Integer page, Integer size);

    EmployeeEntity save(EmployeeEntity employeeEntity);

    public List<EmployeeEntity> filterEmployees(String name, String surname, String sort, String sortType) ;

    TaskEntity saveTask(long id, TaskEntity task);

    void deleteTask(long id, long taskId);

    List<TaskEntity> getTask(long id);
}
