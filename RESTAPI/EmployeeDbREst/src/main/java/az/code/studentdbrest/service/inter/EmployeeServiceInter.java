package az.code.studentdbrest.service.inter;

import az.code.studentdbrest.models.Employee;
import az.code.studentdbrest.models.Task;


import java.util.List;

public interface EmployeeServiceInter {
    List<Employee> getAllEmployee();

    Employee getById(Long id);

    Employee remove(Long id);

    Employee save(Employee employee);

    List<Employee> search(String name, Integer page, Integer size);
    List<Task> getAllTask();
    Task getByIdTask(Long id);

    Task removeTask(Long id);

    Task saveTask(Task task);
}
