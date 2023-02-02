package az.code.springwebdemo.service.impl;

import az.code.springwebdemo.dto.EmployeeDTO;
import az.code.springwebdemo.dto.TaskDTO;
import az.code.springwebdemo.model.Employee;
import az.code.springwebdemo.model.Task;
import az.code.springwebdemo.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
@Slf4j
@Profile("local")
public class OnMemoryEmployeeService implements EmployeeService {
    public static List<Employee> employeeList = new ArrayList<>();
    public static List<Task> taskList = new ArrayList<>();
    private AtomicLong atomicLong = new AtomicLong(0);


    public List<Employee> getAllEmployee() {
        return employeeList;
    }


//    public static List<EmployeeDTO> sort(String name, String surname, String sortType){
//
//        List<EmployeeDTO> list = employeeList.stream()
//                .filter(e->e.getName().equals(name))
//                .filter(e->e.getSurname().equals(surname))
//                .sorted(Comparator.comparing(EmployeeDTO::getName))
//                .collect(Collectors.toList());
//
//        if(sortType.equals("asc")){
//            return list;
//        }
//        else if(sortType.equals("desc")){
//            Collections.reverse(list);
//            return list;
//        }
//            return list;
//    }

    public Employee getById(long id) {
        return employeeList.stream().filter(x->x.getId()==id).findAny().get();
    }

    public void delete(long id){
        employeeList.remove(getById(id));
    }

    @Override
    public List<Employee> search(String name, Integer page, Integer size) {
        return null;
    }

    public Employee save(Employee employee){
        employee.setId(atomicLong.incrementAndGet());
        employee.getTasks().forEach(item -> item.setTask_id(atomicLong.incrementAndGet()));
        employeeList.add(employee);
         return employee;
    }

    public List<Task> getTasks(long id){
        return getById(id).getTasks();
    }

    public Task saveTask(long id,Task task){
        Employee employee = getById(id);
        task.setTask_id(atomicLong.incrementAndGet());
        employee.getTasks().add(task);
        return task;
    }

    public void deleteTask(long id, long task_id) {
        Employee employee = getById(id);
        List<Task> task = employee.getTasks();
        task.stream()
                .filter(t -> t.getTask_id().equals(task_id))
                .findFirst()
                .map(x -> {
                    task.remove(x);
                    return x;
                });

    }

    @Override
    public List<Employee> filterEmployees(String name, String surname, String sort, String sortType) {
        return null;
    }
}
