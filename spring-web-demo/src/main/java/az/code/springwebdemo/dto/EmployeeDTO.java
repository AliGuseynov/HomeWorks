package az.code.springwebdemo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Builder(toBuilder = true)
@ToString(exclude = "tasks")
public class EmployeeDTO {
    long id;
    String name;
    String surname;
    List<TaskDTO> tasks;


}