package az.code.studentdbrest.controller;

import az.code.studentdbrest.dto.EmployeeDto;
import az.code.studentdbrest.dto.TaskDto;
import az.code.studentdbrest.models.Employee;
import az.code.studentdbrest.models.Task;
import az.code.studentdbrest.service.impl.DBEmployeeService;
import az.code.studentdbrest.service.inter.EmployeeServiceInter;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final ObjectMapper objectMapper;
 private final EmployeeServiceInter employeeServiceInter;


    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(objectMapper
                .convertValue(employeeServiceInter.save(objectMapper.convertValue(employeeDto, Employee.class))
                        , EmployeeDto.class));

    }

    @GetMapping("/")
    public ResponseEntity<List> getAllEmpployee() {
        return ResponseEntity.ok(employeeServiceInter.getAllEmployee());
    }

    @DeleteMapping("/remove/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        employeeServiceInter.remove(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Long id) {
        return ResponseEntity.ok(objectMapper.convertValue(employeeServiceInter.getById(id), EmployeeDto.class));
    }
    @PutMapping
    public ResponseEntity<EmployeeDto> update(@RequestBody EmployeeDto employeeDTO) {
        return ResponseEntity.ok(objectMapper
                .convertValue(employeeServiceInter
                        .save(objectMapper.convertValue(employeeDTO, Employee.class)),EmployeeDto.class));
    }
    @PostMapping("/tasks")
    public ResponseEntity<TaskDto> saveTask(@RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(objectMapper
                .convertValue(employeeServiceInter.saveTask(objectMapper.convertValue(taskDto, Task.class))
                        , TaskDto.class));

    }
    @GetMapping("/tasks")
    public ResponseEntity<List> getAllTask() {
        return ResponseEntity.ok(employeeServiceInter.getAllTask());
    }
    @DeleteMapping("/remove/tasks/{id}")
    public void deleteByIdTask(@PathVariable("id") Long id) {
        employeeServiceInter.removeTask(id);
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<TaskDto> getTask(@PathVariable("id") Long id) {
        return ResponseEntity.ok(objectMapper.convertValue(employeeServiceInter.getByIdTask(id), TaskDto.class));
    }
    @PutMapping("/task")
    public ResponseEntity<TaskDto> updateTask(@RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(objectMapper
                .convertValue(employeeServiceInter
                        .saveTask(objectMapper.convertValue(taskDto, Task.class)),TaskDto.class));
    }
}

