package com.example.demoemployeecrud.controller;


import com.example.demoemployeecrud.dto.EmployeeDTO;
import com.example.demoemployeecrud.dto.TaskDTO;
import com.example.demoemployeecrud.services.IEmployeeServices;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {


    public IEmployeeServices employeeServices;

    public EmployeeController(IEmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }

    @GetMapping("/all")
    public List<EmployeeDTO> getEmployeeDTOList() {
        return employeeServices.getAllEmployee();
    }

    @GetMapping("/{id}")
    public EmployeeDTO getById(@PathVariable long id) {
        return employeeServices.getById(id);
    }

    @GetMapping
    public List<EmployeeDTO> searchByName(@RequestParam(required = false) String name, String sortType) {
        return employeeServices.search(name, sortType);
    }

    @DeleteMapping("/{id}")
    public EmployeeDTO delete(@PathVariable long id) {
        return (EmployeeDTO) employeeServices.delete(id);
    }

    @PutMapping
    public void update(EmployeeDTO employeeDTO) {
        employeeServices.update(employeeDTO);
    }
}
