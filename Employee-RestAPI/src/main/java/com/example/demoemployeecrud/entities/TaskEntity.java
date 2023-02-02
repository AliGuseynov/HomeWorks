package com.example.demoemployeecrud.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name= "employee_id", referencedColumnName = "id")
    private EmployeeEntity employeeEntity;
}
