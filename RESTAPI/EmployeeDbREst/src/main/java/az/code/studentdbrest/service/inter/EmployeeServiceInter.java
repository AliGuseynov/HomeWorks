package az.code.studentdbrest.service.inter;

import az.code.studentdbrest.models.Employee;

import java.util.List;

public interface EmployeeServiceInter {
    List<Employee> getAllEmployee();

    Employee getById(Long id);

    Employee remove(Long id);

    Employee save(Employee employee);

    List<Employee> search(String name, Integer page, Integer size);
}
