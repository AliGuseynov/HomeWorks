package com.example.demoemployeecrud.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EmployeeDTO {
    public Long id;
    public String name;
    public String surname;
    public List<TaskDTO> taskDTOList;

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\n' +
                ", taskDTOList=" + taskDTOList +
                '}';
    }
}
