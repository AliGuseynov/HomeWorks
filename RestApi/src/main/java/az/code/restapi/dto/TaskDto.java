package az.code.restapi.dto;

import az.code.restapi.models.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder(toBuilder = true)
public class TaskDto {

    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;
    @JsonIgnore
    private Employee employee;
}
