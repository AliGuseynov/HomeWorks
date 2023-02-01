package az.code.restapi.dto;

import az.code.restapi.models.Task;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class EmployeeDto {

    private Long id;
    private String name;
    private String surname;
    private List<TaskDto> taskList;

}
