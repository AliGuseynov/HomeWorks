package az.code.restapi.repository;

import az.code.restapi.models.Employee;
import az.code.restapi.models.Task;

import java.util.List;

public interface RepoInterface {

    public Employee findEmployeeById(Long id);

    public List<Employee> filterEmployees(String name, String surname, String sort, String sortType);

    public Employee addEmploee(Employee employee);

    public Employee updateEmployee(Long id, Employee employeeTemp);

    public Employee deleteEmployee(Long id);

    public List<Task> getTasks(Long id);

    public Task addTask(Task task);
}
