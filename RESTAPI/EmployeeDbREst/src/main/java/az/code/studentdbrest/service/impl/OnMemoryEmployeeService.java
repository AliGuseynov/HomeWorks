package az.code.studentdbrest.service.impl;

import az.code.studentdbrest.models.Employee;
import az.code.studentdbrest.service.inter.EmployeeServiceInter;

import java.util.List;

public class OnMemoryEmployeeService implements EmployeeServiceInter {
    @Override
    public List<Employee> getAllEmployee() {
        return null;
    }

    @Override
    public Employee getById(Long id) {
        return null;
    }

    @Override
    public Employee remove(Long id) {
        return null;
    }

    @Override
    public Employee save(Employee employee) {
        return null;
    }

    @Override
    public List<Employee> search(String name, Integer page, Integer size) {
        return null;
    }
}
