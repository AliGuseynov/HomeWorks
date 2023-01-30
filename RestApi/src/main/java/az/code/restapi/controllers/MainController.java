package az.code.restapi.controllers;

import az.code.restapi.models.Employee;
import az.code.restapi.repository.RepoLocal;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employees")
public class MainController{

    @Autowired
    ApplicationContext applicationContext;

    private RepoLocal repo;
    @PostConstruct
    private void init(){

        repo = applicationContext.getBean("RepoLocal", RepoLocal.class);
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

}
