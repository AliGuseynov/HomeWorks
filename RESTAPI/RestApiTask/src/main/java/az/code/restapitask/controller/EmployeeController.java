package az.code.restapitask.controller;

import az.code.restapitask.dto.Employee;
import az.code.restapitask.dto.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {
    private static List<Employee> employeeList = new ArrayList<>();

    private void addEmployee() {
        employeeList.add(Employee.builder().id(1l).name("Nihad").surname("Esgerli")
                .tasks(List.of(Task.builder().id(1).title("JOB").description("Search All New Job")
                        .dueDate(LocalDate.now()).build())).build());
        employeeList.add(Employee.builder().id(2l).name("Niko").surname("Askerli")
                .tasks(List.of(Task.builder().id(1).title("JOB").description("Search All New Job")
                        .dueDate(LocalDate.now()).build())).build());
        employeeList.add(Employee.builder().id(3l).name("Anar").surname("Esgerli")
                .tasks(List.of(Task.builder().id(1).title("JOB").description("Search All New Job")
                        .dueDate(LocalDate.now()).build())).build());
        employeeList.add(Employee.builder().id(4l).name("Nihad").surname("Bsker")
                .tasks(List.of(Task.builder().id(1).title("JOB").description("Search All New Job")
                        .dueDate(LocalDate.now()).build())).build());
        employeeList.add(Employee.builder().id(5l).name("Nihad").surname("Bnihad")
                .tasks(List.of(Task.builder().id(1).title("JOB").description("Search All New Job")
                        .dueDate(LocalDate.now()).build())).build());

    }

    @GetMapping("/")
    public ResponseEntity<List> getAll() {
        addEmployee();
        return ResponseEntity.ok(employeeList);
    }

    @GetMapping
    public ResponseEntity<List> getBySurname
            (@RequestParam(name = "surname", required = false) String surname) {
        List<Employee> list = new ArrayList<>();
        for (Employee employee : employeeList
        ) {
            if (employee.getSurname().equals(surname)) {
                list.add(employee);

            }
        }
        List<Employee> employees = list.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
        return ResponseEntity.ok(employees);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") long id) {
        Employee employee1 = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employee1 = employee;
            }
        }
        return ResponseEntity.ok(employee1);
    }

    @PostMapping("/save")
    public void saveEmployee(@RequestBody Employee employee) {
        for(Employee employee1:employeeList){
            if(employee1.getId()== employee.getId()){

            }else{
                employeeList.add(employee);

            }
        }

    }

    @PutMapping("{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        for (Employee employee1 : employeeList
        ) {
            if (employee.getId() == id) {
                employee1.setName(employee.getName());
                employee1.setSurname(employee.getSurname());
                employee1.setTasks(employee.getTasks());
            }
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        Employee employee = null;
        for (Employee employee1 : employeeList
        ) {
            if (employee1.getId() == id) {
                employee = employee1;
            }
        }
        employeeList.remove(employee);
    }

    @GetMapping("/{id}/tasks")
    public ResponseEntity<List> getTask(@PathVariable("id") int id) {
        List<Task> tasks = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                tasks = employee.getTasks();
            }
        }
        return ResponseEntity.ok(tasks);
    }

    @DeleteMapping("/{id}/tasks/{taskId}")
    public void deleteById(@PathVariable("id") int id,
                           @PathVariable("id") int taskId) {
        Task task1 = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                for (Task task : employee.getTasks()
                ) {
                    if (task.getId() == taskId) {
                        task1 = task;
                    }
                }
            }
            employee.getTasks().remove(task1);
        }

    }

    @PostMapping("/{id}")
    public void saveTask(@PathVariable("id") int id, @RequestBody List<Task> task) {

        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employee.setTasks(task);
            }
        }
    }

    @PutMapping("{id}/tasks")
    public void updateTask(@PathVariable("id") int id,
                           @PathVariable("id") int taskId,
                           @RequestBody Task task) {
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                for (Task task1 : employee.getTasks()
                ) {
                    if (task1.getId() == taskId) {
                        task1.setTitle(task.getTitle());
                        task1.setDescription(task.getDescription());
                        task1.setDueDate(task.getDueDate());
                    }
                }
            }
        }

    }
//    @PostMapping("/Employees")
//    public ResponseEntity<ResponseDTO> addUser(@RequestBody Employee employee){
//       Employee employee1=new Employee();
//       employee1.setId(employee.getId());
//        employee1.setName(employee.getName());
//        employee1.setSurname(employee.getSurname());
//      employee1.se
//        return ResponseEntity.ok(ResponseDTO.of(userDTO, "Succesfuly added"));
//    }
}
