package az.code.springwebdemo.service;

import az.code.springwebdemo.model.Employee;
import az.code.springwebdemo.model.Task;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    Employee getById(long id);

    void delete(long id);

    List<Employee> search(String name, Integer page, Integer size);

    Employee save(Employee employee);

    List<Task> getTasks(long id);

    Task saveTask(long id, Task task);

    void deleteTask(long id, long task_id);

    public List<Employee> filterEmployees(String name, String surname, String sort, String sortType);
}
