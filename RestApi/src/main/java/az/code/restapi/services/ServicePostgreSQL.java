package az.code.restapi.services;

import az.code.restapi.models.Employee;
import az.code.restapi.models.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

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
        if (sortType == null || !sortType.equals("desc") ){
            sortType = "asc";
        }

        String queryStr = "SELECT e from Employee e where e.name like :name and e.surname like :surname ORDER BY " + sort + " " + sortType;

        Query query = em
                .createQuery(queryStr)
                .setParameter("name", "%" + name + "%")
                .setParameter("surname", "%" + surname + "%")
                ;

        List<Employee> employeeList = query.getResultList();
        return employeeList;
    }

    @Override
    @Transactional
    public Employee addEmployee(Employee employee) {


        List<Task> taskList= employee.getTaskList();
        employee.setTaskList(new ArrayList<>());

        Employee res = em.merge(employee);
        res.setTaskList(taskList);
        em.merge(res);
        return res;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employeeTemp) {
        return null;
    }

    @Override
    @Transactional
    public Employee deleteEmployee(Long id) {
        Employee tempEmployee = em.find(Employee.class, id);

        int deletedTasksCount = em.createNativeQuery("DELETE from Task e where employee_id = :id")
                .setParameter("id", id).executeUpdate();

        int deletedCount = em.createQuery("DELETE from Employee e where e.id = :id")
                .setParameter("id", id).executeUpdate();

        System.out.println(deletedTasksCount + " tasks deleted");
        System.out.println(deletedCount + " elements deleted");

        return tempEmployee;
    }

    @Override
    public List<Task> getTasks(Long id) {

        String queryStr = "SELECT * from task where employee_id = ?1";

        Query query = em
                .createNativeQuery(queryStr, Task.class)
                .setParameter(1, id)
                ;

        List<Task> taskList = query.getResultList();

    return taskList;

    }

    @Override
    @Transactional
    public Task addTask(Long EmployeeID, Task task) {
        Employee employee = findEmployeeById(EmployeeID);
        employee.getTaskList().add(task);
        em.merge(employee);
        return employee.getTaskList().get(employee.getTaskList().size()-1);
    }

    @Override
    @Transactional
    public Task updateTask(Long EmployeeID, Task task, Long taskId) {

        Employee employee = findEmployeeById(EmployeeID);

        task.setEmployee(employee);
        em.merge(task);

        return task;

    }

    @Override
    @Transactional
    public Task deleteTask(Long EmployeeID, Long taskId) {
        Task task = em.createQuery("SELECT t from Task t where t.id = :id", Task.class)
                .setParameter("id", taskId)
                .getSingleResult();


        int deletedTasksCount = em.createNativeQuery("DELETE from Task e where e.id = :id")
                .setParameter("id", taskId).executeUpdate();

        System.out.println(deletedTasksCount + " tasks deleted");
        return task;
    }
}
