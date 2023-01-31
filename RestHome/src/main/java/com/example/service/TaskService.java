package com.example.service;

import com.example.entity.Employee;
import com.example.entity.Task;
import com.example.repo.TaskRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    private final EmployeeService employeeService;

    private final ObjectMapper objectMapper;
    @Transactional
    public Task saveTask(int id,Task task){
        Employee employee = objectMapper.convertValue(employeeService.getEmployeeById(id),Employee.class);
        employee.getTaskList().add(taskRepository.save(task));
        return task;
    }

    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }

    public List<Task> getTaskById(int id){
        Employee employee = objectMapper.convertValue(employeeService.getEmployeeById(id),Employee.class);
        return employee.getTaskList();

    }

    @Transactional
    public void deleteTask(int id,int taskId){
        Employee employee = objectMapper.convertValue(employeeService.getEmployeeById(id),Employee.class);
        taskRepository.deleteById(employee.getTaskList().get(taskId).getId());
    }



}
