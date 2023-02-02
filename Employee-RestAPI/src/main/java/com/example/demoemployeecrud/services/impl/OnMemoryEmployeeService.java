package com.example.demoemployeecrud.services.impl;

import com.example.demoemployeecrud.dto.EmployeeDTO;
import com.example.demoemployeecrud.dto.TaskDTO;
import com.example.demoemployeecrud.entities.EmployeeEntity;
import com.example.demoemployeecrud.entities.TaskEntity;
import com.example.demoemployeecrud.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
@Slf4j
@Profile("local")
public class OnMemoryEmployeeService implements EmployeeService {
    private List<EmployeeEntity> employeeList = new ArrayList<>();
    private AtomicLong atomicLong = new AtomicLong(0);

    @Override
    public List<EmployeeEntity> getAllEmployee() {
        return employeeList;

    }

    @Override
    public EmployeeEntity getById(long id) {
        return employeeList.stream()
                .filter(e -> e.getId() == id).findAny().get();
    }

    @Override
    public void delete(long id) {
        employeeList.remove(getById(id));
    }


    @Override
    public List<EmployeeEntity> search(String name, Integer page, Integer size) {
        return employeeList;
    }

    @Override
    public EmployeeEntity save(EmployeeEntity employee) {
        employee.setId(atomicLong.incrementAndGet());
        employee.getTaskEntities().forEach(item -> item.setId(atomicLong.incrementAndGet()));
        employeeList.add(employee);
        return employee;
    }

    @Override
    public List<EmployeeEntity> filterEmployees(String name, String surname, String sort, String sortType) {
        return null;
    }

    @Override
    public TaskEntity saveTask(long id, TaskEntity task) {

        EmployeeEntity employee = getById(id);
        task.setId(atomicLong.incrementAndGet());
        employee.getTaskEntities().add(task);

        return task;
    }

    @Override
    public void deleteTask(long id, long taskId) {
        EmployeeEntity employee = getById(id);
        List<TaskEntity> task = employee.getTaskEntities();
        task.stream()
                .filter(t -> t.getId().equals(taskId))
                .findFirst()
                .map(x -> {
                    task.remove(x);
                    return x;
                });

    }

    @Override
    public List<TaskEntity> getTask(long id) {

        return getById(id).getTaskEntities();
    }
}
