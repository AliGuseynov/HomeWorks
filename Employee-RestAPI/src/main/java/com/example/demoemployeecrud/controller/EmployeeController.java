package com.example.demoemployeecrud.controller;

import com.example.demoemployeecrud.dto.EmployeeDTO;
import com.example.demoemployeecrud.dto.TaskDTO;
import com.example.demoemployeecrud.entities.EmployeeEntity;
import com.example.demoemployeecrud.entities.TaskEntity;
import com.example.demoemployeecrud.services.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    private final ObjectMapper objectMapper;

    @PostMapping
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(objectMapper
                .convertValue(employeeService.save(objectMapper.convertValue(employeeDTO, EmployeeEntity.class)),
                        EmployeeDTO.class));

    }


    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getElementById(@PathVariable long id) {
        return ResponseEntity.ok(objectMapper.convertValue(employeeService.getById(id), EmployeeDTO.class));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        employeeService.delete(id);
    }


    @PutMapping
    public ResponseEntity<EmployeeDTO> update(@RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(objectMapper
                .convertValue(employeeService
                        .save(objectMapper.convertValue(employeeDTO, EmployeeEntity.class)), EmployeeDTO.class));
    }

//    @GetMapping
//    public ResponseEntity<List<EmployeeDTO>> search(@RequestParam(required = false) String name,
//                                                    @RequestParam(required = false)Integer page,
//                                                    @RequestParam(required = false) Integer size) {
//
//        return ResponseEntity.ok(employeeService.search(name, page, size).stream()
//                .map(item -> objectMapper.convertValue(item, EmployeeDTO.class)).collect(Collectors.toList()));
//    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee() {
        return ResponseEntity.ok(employeeService.getAllEmployee().stream().map(
                e -> objectMapper.convertValue(e, EmployeeDTO.class)).collect(Collectors.toList()));
    }


    @PostMapping("/task/{id}")
    public ResponseEntity<TaskDTO> saveTask(@PathVariable long id, @RequestBody TaskDTO taskDTO) {
        return ResponseEntity.ok(objectMapper
                .convertValue(employeeService.saveTask(id, objectMapper.convertValue(taskDTO, TaskEntity.class)),
                        TaskDTO.class));

    }

    @DeleteMapping("/{id}/task/{taskId}")
    public void deleteTask(@PathVariable long id, @PathVariable long taskId) {
        employeeService.deleteTask(id, taskId);
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<List<TaskDTO>> getTask(@PathVariable long id) {
        return ResponseEntity.ok(employeeService.getTask(id).stream().map(t -> objectMapper
                .convertValue(t, TaskDTO.class)).collect(Collectors.toList()));
    }

    @PutMapping("/task/{id}")
    public ResponseEntity<TaskDTO> update(@PathVariable long id, @RequestBody TaskDTO taskDTO) {
        return ResponseEntity.ok(objectMapper
                .convertValue(employeeService.saveTask(id, objectMapper.convertValue(taskDTO, TaskEntity.class)),
                        TaskDTO.class));

    }

}
