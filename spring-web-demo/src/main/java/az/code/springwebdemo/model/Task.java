package az.code.springwebdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long task_id;
    private String title;
    private String description;
    private Date dueDate;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name= "employee_id", referencedColumnName = "id")
    private Employee employee;
}
