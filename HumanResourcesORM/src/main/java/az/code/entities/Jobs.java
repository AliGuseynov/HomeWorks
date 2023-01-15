package az.code.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "jobs")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private String jobId;

    @Column(name = "job_title")
    private String jobTitle;
    @Column(name = "min_salary")
    private BigDecimal minSalary;
    @Column(name = "max_salary")
    private BigDecimal maxSalary;
}
