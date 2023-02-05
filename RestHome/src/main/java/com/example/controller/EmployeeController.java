package com.example.controller;

import com.example.CreateList;
import com.example.dto.EmployeeDto;
import com.example.dto.TaskDto;
import com.example.entity.Employee;
import com.example.entity.Task;
import com.example.service.EmployeeService;
import com.example.service.TaskService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final TaskService taskService;
    private final ObjectMapper objectMapper;
    private List<EmployeeDto> employeeDtoList = CreateList.createList();


    @GetMapping("/user")
    public String getUser(){
        return "Salam user";
    }

    @GetMapping("/admin")
    public String getAdmin(){
        return "Salam admin";
    }

    @Secured("ROLE_USER")
    @GetMapping("/{id}")
    public EmployeeDto getById(@PathVariable int id) {
        return objectMapper.convertValue(employeeService.getEmployeeById(id), EmployeeDto.class);
    }

    @Secured("ROLE ADMIN")
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/{id}")
    public EmployeeDto updateEmployee(@RequestBody Employee employee) {
        return objectMapper.convertValue(employeeService.updateEmployee(employee), EmployeeDto.class);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/{id}/tasks")
    public ResponseEntity<List<Task>> getAllTask(@PathVariable int id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }


    @PutMapping("/{id}/tasks/{taskId}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable int id, @PathVariable int taskId) {
        return ResponseEntity.ok(TaskDto.builder().id(taskId).build());
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/{id}/tasks")
    public ResponseEntity<TaskDto> addTask(@PathVariable int id, @RequestBody Task task) {
        return ResponseEntity.ok(objectMapper.convertValue(taskService.saveTask(id, task), TaskDto.class));
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}/tasks/{taskId}")
    public void deleteTask(@PathVariable int id, @PathVariable int taskId) {
        taskService.deleteTask(taskId);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getEmployee(@RequestParam String name, @RequestParam String surname) {
        List<EmployeeDto> result = employeeDtoList.stream().filter(employee -> employee.getName().equals(name) && employee.getSurName().equals(surname)).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }
}


//https://discord.com/api/oauth2/authorize?client_id=1071112862619148330&permissions=8&scope=bot