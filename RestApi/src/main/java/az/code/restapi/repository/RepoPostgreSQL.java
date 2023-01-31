package az.code.restapi.repository;

import az.code.restapi.models.Employee;
import az.code.restapi.models.Task;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Getter
@Component
@Profile("PostgreSQL")
@RequiredArgsConstructor
public class RepoPostgreSQL implements RepoInterface{
    private final EntityManager em;

    @Override
    public Employee findEmployeeById(Long id) {
        return null;
    }

    @Override
    public List<Employee> filterEmployees(String name, String surname, String sort, String sortType) {
        return null;
    }

    @Override
    @Transactional
    public Employee addEmploee(Employee employee) {

        Employee res = em.merge(employee);
        return res;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employeeTemp) {
        return null;
    }

    @Override
    public Employee deleteEmployee(Long id) {
        return null;
    }

    @Override
    public List<Task> getTasks(Long id) {
        return null;
    }

    @Override
    public Task addTask(Long EmployeeID, Task task) {
        return null;
    }

    @Override
    public Task updateTask(Long EmployeeID, Task task, Long taskId) {
        return null;
    }

    @Override
    public Task deleteTask(Long EmployeeID, Long taskId) {
        return null;
    }
}
