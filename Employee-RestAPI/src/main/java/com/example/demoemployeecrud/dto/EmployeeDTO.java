package com.example.demoemployeecrud.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Builder
@ToString(exclude = "taskEntities")
public class EmployeeDTO {
    public Long id;
    public String name;
    public String surname;
    public List<TaskDTO> taskEntities;
}
