package com.example.demoemployeecrud.services.impl;

import com.example.demoemployeecrud.entities.EmployeeEntity;
import com.example.demoemployeecrud.entities.TaskEntity;
import com.example.demoemployeecrud.repo.EmployeeRepository;
import com.example.demoemployeecrud.repo.TaskRepository;
import com.example.demoemployeecrud.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
@Profile("prod")
public class DbEmployeeService implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final TaskRepository taskRepository;

    @Autowired
    public DbEmployeeService(EmployeeRepository employeeRepository, TaskRepository taskRepository) {
        this.employeeRepository = employeeRepository;
        this.taskRepository = taskRepository;
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

    @Override
    public List<EmployeeEntity> filterEmployees(String name, String surname, String sort, String sortType) {

        List<EmployeeEntity> employeeList = new ArrayList<>();

        final String sortS = sort;

        employeeList = employeeList.stream()
                .filter(employee -> name != null ? employee.getName().toLowerCase().contains(name.toLowerCase()) : true)
                .filter(employee -> surname != null ? employee.getSurname().toLowerCase().contains(surname.toLowerCase()) : true)
                .sorted(((o1, o2) ->
                        sortS == null ? 0 :
                                sortS.equalsIgnoreCase("name") ? o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase()) :
                                        sortS.equalsIgnoreCase("surname") ? o1.getSurname().toLowerCase().compareTo(o2.getSurname().toLowerCase())
                                                : 0
                ))
                .collect(Collectors.toList());

        if (
                ((sortType != null) && sortType.equalsIgnoreCase("desc"))
        ) {
            Collections.reverse(employeeList);
        }
        return employeeList;
    }

    @Override
    public TaskEntity saveTask(long id, TaskEntity task) {

        task.setEmployeeEntity(getById(id));
        return taskRepository.save(task);

    }

    @Override
    public void deleteTask(long id, long taskId) {

        taskRepository.delete(taskRepository.findById(taskId).get());

    }

    @Override
    public List<TaskEntity> getTask(long id) {
        return employeeRepository.findById(id).get().getTaskEntities();

    }
}
