package az.code.restapi.controllers;

import az.code.restapi.dto.EmployeeDto;
import az.code.restapi.dto.TaskDto;
import az.code.restapi.models.Employee;
import az.code.restapi.models.Task;
import az.code.restapi.services.ServiceInterface;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class MainController{

    @Autowired
    ApplicationContext applicationContext;

    private final ObjectMapper objectMapper;

    private ServiceInterface repo;
    @PostConstruct
    private void init(){

        repo = applicationContext.getBean(ServiceInterface.class);
    }



    @GetMapping
    public ResponseEntity<List<EmployeeDto>> searchEmployees(@RequestParam(required = false) String name,
                                                             String surname, String sort, String sortType
                                                          ){

        return ResponseEntity.ok(repo.filterEmployees(name,surname,sort,sortType)
                .stream()
                .map(item -> objectMapper.convertValue(item, EmployeeDto.class))
                .collect(Collectors.toList()));

    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getById(@PathVariable Long id){

        return ResponseEntity.ok(objectMapper.convertValue(repo.findEmployeeById(id), EmployeeDto.class));

    }

    @PostMapping
    public EmployeeDto addEmployee(@RequestBody Employee employee){
        Employee empAdded = repo.addEmployee(employee);
        return objectMapper.convertValue(empAdded,EmployeeDto.class);
    }

    @PutMapping("/{id}")
    public EmployeeDto updateEmployee(@PathVariable Long id,
                                   @RequestBody EmployeeDto employeeDto){


        return
                objectMapper.convertValue(
                repo.updateEmployee(id, objectMapper.convertValue(employeeDto, Employee.class))
                ,EmployeeDto.class);
    }

    @DeleteMapping("/{id}")
    public EmployeeDto deleteEmployee(@PathVariable Long id){

        return
                objectMapper.convertValue(
                repo.deleteEmployee(id)
                ,EmployeeDto.class);
    }

    @GetMapping("/{id}/tasks")
    public ResponseEntity<List<TaskDto>> getEmployeeTasks(@PathVariable Long id){

        return ResponseEntity.ok(
                repo.getTasks(id)
                        .stream()
                        .map(item -> objectMapper.convertValue(item, TaskDto.class))
                        .collect(Collectors.toList()));
    }

    @PostMapping("/{id}/tasks")
    public TaskDto addTask(@RequestBody TaskDto taskDto, @PathVariable Long id){
        return
                objectMapper.convertValue(
                        repo.addTask(id,
                                objectMapper.convertValue(taskDto, Task.class)),
                        TaskDto.class);
    }

    @PutMapping("/{id}/tasks/{taskId}")
    public TaskDto updateTask(@PathVariable Long id,
                           @PathVariable Long taskId,
                               @RequestBody TaskDto taskDto){


        return
                objectMapper.convertValue(
                        repo.updateTask(id,
                                objectMapper.convertValue(taskDto, Task.class)
                                , taskId)
                        , TaskDto.class);
    }

    @DeleteMapping("/{id}/tasks/{taskId}")
    public Task deleteTask(@PathVariable Long id,
                           @PathVariable Long taskId){
        return repo.deleteTask(id, taskId);
    }

}
