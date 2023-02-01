package az.code.restapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;

    @ManyToOne()
    @JsonIgnore
    @ToString.Exclude
    @JoinColumn(name= "employee_id", referencedColumnName = "id")
    private Employee employee;

}
