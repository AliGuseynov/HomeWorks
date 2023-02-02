package az.code.springwebdemo.service.impl;

import az.code.springwebdemo.model.Employee;
import az.code.springwebdemo.model.Task;
import az.code.springwebdemo.repo.EmployeeRepository;
import az.code.springwebdemo.repo.TaskRepository;
import az.code.springwebdemo.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@Profile("prod")
@AllArgsConstructor
public class DbEmployeeService implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final TaskRepository taskRepository;

    @Override
    public List<Employee> filterEmployees(String name, String surname, String sort, String sortType) {

        List<Employee> employeeList = new ArrayList<>();

        final String sortS = sort;

        employeeList = getAllEmployee().stream()
                .filter(employee -> name != null ? employee.getName().toLowerCase().contains(name.toLowerCase()) : true)
                .filter(employee -> surname != null ? employee.getSurname().toLowerCase().contains(surname.toLowerCase()) : true)
                .sorted(((o1, o2) ->
                        sortS == null ? 0 :
                                sortS.equalsIgnoreCase("name") ? o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase()) :
                                        sortS.equalsIgnoreCase("surname") ? o1.getSurname().toLowerCase().compareTo(o2.getSurname().toLowerCase())
                                                : 0
                ))
                .collect(Collectors.toList());

        if (
                ((sortType != null) && sortType.equalsIgnoreCase("desc"))
        ) {
            Collections.reverse(employeeList);
        }
        return employeeList;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public void delete(long id) {
        employeeRepository.delete(employeeRepository.findById(id).get());
    }

    @Override
    public List<Employee> search(String name, Integer page, Integer size) {
        return null;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Task> getTasks(long id) {
        return getById(id).getTasks();
    }

    @Override
    public Task saveTask(long id, Task task) {
        task.setEmployee(getById(id));
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(long id, long task_id){
        Task deletedTask = taskRepository.findById(task_id).get();
        employeeRepository.findById(id).get().getTasks().remove(deletedTask);
        taskRepository.delete(deletedTask);
    }


}

