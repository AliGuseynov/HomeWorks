package az.code.studentdbrest.service.impl;

import az.code.studentdbrest.models.Employee;
import az.code.studentdbrest.repo.EmployeeDataRepo;
import az.code.studentdbrest.service.inter.EmployeeServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DBEmployeeService implements EmployeeServiceInter {
    private final EmployeeDataRepo employeeDataRepo;

    @Override
    public Employee save(Employee employee) {
        return employeeDataRepo.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeDataRepo.findAll();
    }

    @Override
    public Employee getById(Long id) {
        return employeeDataRepo.findById(id).get();
    }

    @Override
    public Employee remove(Long id) {
        employeeDataRepo.delete(getById(id));
        return getById(id);
    }
    @Override
    public List<Employee> search(String name, Integer page, Integer size) {
        return null;
    }
}
