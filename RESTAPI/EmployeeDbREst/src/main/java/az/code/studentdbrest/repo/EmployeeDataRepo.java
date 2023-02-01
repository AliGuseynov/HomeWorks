package az.code.studentdbrest.repo;

import az.code.studentdbrest.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeDataRepo extends JpaRepository<Employee, Long> {
    @Query("select s from Employee s ")
    List<Employee> getAll();
}
