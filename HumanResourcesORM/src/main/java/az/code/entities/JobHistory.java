package az.code.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.PrimitiveIterator;

@Entity
@Table(name = "job_history")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class JobHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "start_date")
    private Timestamp startDate;

    @Column(name = "end_date")
    private Timestamp endDate;

//    private List<Jobs> jobsList;
//    private List<Departments> departmentsList;
//    private List<Employees> employees;
}
