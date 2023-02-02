package az.code.springwebdemo.controller;

import az.code.springwebdemo.dto.EmployeeDTO;
import az.code.springwebdemo.dto.TaskDTO;
import az.code.springwebdemo.model.Employee;
import az.code.springwebdemo.model.Task;
import az.code.springwebdemo.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final ObjectMapper objectMapper;


    @GetMapping
    public List<Employee> getAll(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getElementById(@PathVariable long id){
        return ResponseEntity.ok(objectMapper.convertValue(employeeService.getById(id), EmployeeDTO.class));
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employeeDTO){
      //  employeeService.save(employeeDTO);
        return ResponseEntity.ok(objectMapper
                .convertValue(employeeService.save(objectMapper.convertValue(employeeDTO, Employee.class)),
                        EmployeeDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(objectMapper
                .convertValue(employeeService
                        .save(objectMapper.convertValue(employeeDTO, Employee.class)), EmployeeDTO.class));
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable long id){
        employeeService.delete(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDTO>> getEmployeesByName(@RequestParam(required = false) String name,@RequestParam(required = false) String surname,@RequestParam String sort, @RequestParam  String sortType){
        List<Employee> list= employeeService.filterEmployees(name, surname, sort, sortType);

        return ResponseEntity.ok(list.stream().map(x-> objectMapper.convertValue(x, EmployeeDTO.class)).collect(Collectors.toList()));
    }

    @GetMapping("/{id}/tasks")
    public ResponseEntity<List<TaskDTO>> getTasksById(@PathVariable long id){
        return ResponseEntity.ok(employeeService.getTasks(id).stream().map(x->objectMapper.convertValue(x, TaskDTO.class)).collect(Collectors.toList()));
    }

    @PostMapping("/{id}")
    public ResponseEntity<TaskDTO> saveTask(@PathVariable long id, @RequestBody TaskDTO taskDTO){
        return ResponseEntity.ok(objectMapper.convertValue(employeeService.saveTask(id,objectMapper.convertValue(taskDTO, Task.class)), TaskDTO.class));
    }

    @PutMapping("/{id}/tasks")
    public ResponseEntity<TaskDTO> updateEmployeeTask(@PathVariable long id, @RequestBody TaskDTO task) {
         return ResponseEntity.ok(objectMapper
                .convertValue(employeeService
                        .saveTask(id, objectMapper.convertValue(task, Task.class)), TaskDTO.class));
    }

    @DeleteMapping("/{id}/tasks/{task_id}")
    public void deleteEmployeesTask( @PathVariable long id, @PathVariable long task_id){
        employeeService.deleteTask(id, task_id);
    }

}
