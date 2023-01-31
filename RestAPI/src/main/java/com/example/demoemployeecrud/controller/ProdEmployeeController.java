package com.example.demoemployeecrud.controller;


import com.example.demoemployeecrud.dto.EmployeeDTO;
import com.example.demoemployeecrud.services.ProdEmployeeService;
import com.example.demoemployeecrud.services.IEmployeeServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prod/employee")
public class ProdEmployeeController {


    public IEmployeeServices employeeServices;

    public ProdEmployeeController(IEmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }

    @GetMapping("/all")
    public List<EmployeeDTO> getEmployeeDTOList() {
        employeeServices.getAllEmployee();
        return ProdEmployeeService.employeeDTOList;
    }

    @GetMapping("/{id}")
    public EmployeeDTO getById(@PathVariable long id) {
        return employeeServices.getById(id);
    }

    @GetMapping
    public List<EmployeeDTO> searchByName(@RequestParam(required = false) String name,
                                          @RequestParam(required = false) String sortType) {
        return employeeServices.search(name, sortType);
    }

    @DeleteMapping("/{id}")
    public EmployeeDTO delete(@PathVariable long id) {

        return (EmployeeDTO) employeeServices.delete(id);
    }

    @PutMapping("{id}")
    public void update(@PathVariable long id, EmployeeDTO employeeDTO) {
        employeeServices.update(id,employeeDTO);
    }

    @PostMapping
    public void save(@RequestBody EmployeeDTO employeeDTO) {
        employeeServices.save(employeeDTO);
    }
}
