package com.example.demoemployeecrud.controller;

import com.example.demoemployeecrud.dto.EmployeeDTO;
import com.example.demoemployeecrud.entities.EmployeeEntity;
import com.example.demoemployeecrud.services.local.IEmployeeServicesLocal;
import com.example.demoemployeecrud.services.local.LocalEmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/local/employee")
@RequiredArgsConstructor
public class LocalEmployeeController {

    private final LocalEmployeeService employeeServicesLocal;

    private final ObjectMapper objectMapper;

    @PostMapping
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(objectMapper
                .convertValue(employeeServicesLocal.save(objectMapper.convertValue(employeeDTO, EmployeeEntity.class)),
                        EmployeeDTO.class));

    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeEntity>> getAllEmployee() {
        return ResponseEntity.ok(employeeServicesLocal.getAllEmployee());
    }


    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getElementById(@PathVariable long id) {
        return ResponseEntity.ok(objectMapper.convertValue(employeeServicesLocal.getById(id), EmployeeDTO.class));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        employeeServicesLocal.delete(id);
    }


    @PutMapping
    public ResponseEntity<EmployeeDTO> update(@RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(objectMapper
                .convertValue(employeeServicesLocal
                        .update(objectMapper.convertValue(employeeDTO, EmployeeEntity.class)), EmployeeDTO.class));
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeDTO>> searchByName(@RequestParam(required = false) String name, int page, int size) {

        return ResponseEntity.ok(employeeServicesLocal.search(name, page, size).stream()
                .map(item -> objectMapper.convertValue(item, EmployeeDTO.class)).collect(Collectors.toList()));
    }
}
