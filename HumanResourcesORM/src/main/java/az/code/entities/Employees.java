package az.code.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "hire_name")
    private Timestamp hireDate;
    @Column(name = "salary")
    private BigDecimal salary;
    @Column(name = "commission_pct")
    private BigDecimal commissionPct;

//    private List<Jobs> jobsList;
//    private List<Departments> departmentsList;

}
