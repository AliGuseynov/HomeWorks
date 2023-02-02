package com.example.demoemployeecrud.entities;

import com.example.demoemployeecrud.dto.TaskDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;

    @OneToMany(mappedBy = "employeeEntity", fetch = FetchType.EAGER)
    private List<TaskEntity> taskEntities;

    public void setTaskEntities(List<TaskEntity> taskEntities) {
        for(TaskEntity task : taskEntities){
            task.setEmployeeEntity(this);
        }
        this.taskEntities = taskEntities;
    }
}
