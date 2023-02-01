package com.example.demoemployeecrud.controller;

import com.example.demoemployeecrud.dto.EmployeeDTO;
import com.example.demoemployeecrud.entities.EmployeeEntity;
import com.example.demoemployeecrud.services.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
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
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAll() {
        return ResponseEntity.ok(employeeService.getAllEmployee().stream()
                .map(x->objectMapper.convertValue(x,EmployeeDTO.class))
                .collect(Collectors.toList()));
    }
}
