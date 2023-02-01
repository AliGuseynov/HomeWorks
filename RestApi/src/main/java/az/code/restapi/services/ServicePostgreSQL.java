package az.code.restapi.services;

import az.code.restapi.models.Employee;
import az.code.restapi.models.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
@Getter
@Component
@Profile("PostgreSQL")
@RequiredArgsConstructor
public class ServicePostgreSQL implements ServiceInterface {
    private final EntityManager em;

    @Override
    public Employee findEmployeeById(Long id) {
        return em.find(Employee.class, id);
    }

    @Override
    public List<Employee> filterEmployees(String name, String surname, String sort, String sortType) {

        if (sort == null ||
                (!sort.equals("name") && !sort.equals("surname"))){
            sort = "name";
        }


        Query query = em
                .createQuery("SELECT e from Employee e where e.name like :name and e.surname like :surname ORDER BY surname")
//                .createNativeQuery(" SELECT * FROM employee where name like ?1 and surname like ?2 ORDER BY ?3", Employee.class)
                .setParameter("name", "%" + name + "%")
                .setParameter("surname", "%" + surname + "%")
//                .setParameter("order", "" + sort)
                ;

        List<Employee> employeeList = query.getResultList();
        return employeeList;
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
