package az.code.restapi.controllers;

import az.code.restapi.models.Employee;
import az.code.restapi.models.Task;
import az.code.restapi.repository.RepoInterface;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class MainController{

    @Autowired
    ApplicationContext applicationContext;

    private RepoInterface repo;
    @PostConstruct
    private void init(){

        repo = applicationContext.getBean(RepoInterface.class);
    }



    @GetMapping
    public ResponseEntity<List<Employee>> searchEmployees(@RequestParam(required = false) String name,
                                                          @RequestParam(required = false) String surname,
                                                          @RequestParam(required = false) String sort,
                                                          @RequestParam(required = false) String sortType
                                                          ){

        return ResponseEntity.ok(repo.filterEmployees(name,surname,sort,sortType));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id){

        return ResponseEntity.ok(repo.findEmployeeById(id));

    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        return repo.addEmploee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id,
                                   @RequestBody Employee employee){


        return repo.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public Employee deleteEmployee(@PathVariable Long id){

        return repo.deleteEmployee(id);
    }

    @GetMapping("/{id}/tasks")
    public ResponseEntity<List<Task>> getEmployeeTasks(@PathVariable Long id){

        return ResponseEntity.ok(repo.getTasks(id));
    }

    @PostMapping("/{id}/tasks")
    public Task addTask(@RequestBody Task task, @PathVariable Long id){
        return repo.addTask(id, task);
    }

    @PutMapping("/{id}/tasks/{taskId}")
    public Task updateTask(@PathVariable Long id,
                           @PathVariable Long taskId,
                               @RequestBody Task task){


        return repo.updateTask(id, task, taskId);
    }

    @DeleteMapping("/{id}/tasks/{taskId}")
    public Task deleteTask(@PathVariable Long id,
                           @PathVariable Long taskId){
        return repo.deleteTask(id, taskId);
    }

}
