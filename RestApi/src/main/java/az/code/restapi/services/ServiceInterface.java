package az.code.restapi.services;

import az.code.restapi.models.Employee;
import az.code.restapi.models.Task;

import java.util.List;

public interface ServiceInterface {

    public Employee findEmployeeById(Long id);

    public List<Employee> filterEmployees(String name, String surname, String sort, String sortType);

    public Employee addEmployee(Employee employee);

    public Employee updateEmployee(Long id, Employee employeeTemp);

    public Employee deleteEmployee(Long id);

    public List<Task> getTasks(Long id);

    public Task addTask(Long EmployeeID, Task task);
    public Task updateTask(Long EmployeeID, Task task, Long taskId);
    public Task deleteTask(Long EmployeeID, Long taskId);



}
