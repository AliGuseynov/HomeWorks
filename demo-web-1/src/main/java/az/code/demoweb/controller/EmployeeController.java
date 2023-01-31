package az.code.demoweb.controller;

import az.code.demoweb.dto.EmployeeDto;
import az.code.demoweb.dto.TaskDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    List<EmployeeDto> listEmp = new ArrayList<EmployeeDto>();
    List<TaskDto> listTask = new ArrayList<TaskDto>();

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAll() {

        listTask.add(new TaskDto(2l, "task1", "dkjghkjfg"));
        listTask.add(new TaskDto(3l, "task2", "dkjghkjfg"));
        listEmp.add(new EmployeeDto(1l, "leyla", "hajiyeva", listTask));
        listEmp.add(new EmployeeDto(5l, "ali", "hajiyev", listTask));
        return ResponseEntity.ok(listEmp);
//       return listEmp.stream().forEach(item-> System.out.println(item));

    }

    @GetMapping("/search")
    public ResponseEntity<List<EmployeeDto>> search(@RequestParam(required=false) String name) {
        return ResponseEntity.ok(listEmp.stream().filter((item) -> item.getName().equals(name) ? true : false)
                .collect(Collectors.toList()));
    }
    @PostMapping
    public ResponseEntity<List<EmployeeDto>> save(@RequestBody EmployeeDto employeeDto) {
        listEmp.add(employeeDto);
        return ResponseEntity.ok(listEmp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeDto> deleteById(@PathVariable long id) {
        return ResponseEntity.ok(listEmp.get((int) id));
    }
}
