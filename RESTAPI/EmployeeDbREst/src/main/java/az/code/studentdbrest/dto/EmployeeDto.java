package az.code.studentdbrest.dto;

import az.code.studentdbrest.models.Task;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Data
@Builder
@ToString(exclude = "taskEntities")
public class EmployeeDto {
    public Long id ;
    public String name;
    public String surname ;
    public List<TaskDto> taskEntities;
}
