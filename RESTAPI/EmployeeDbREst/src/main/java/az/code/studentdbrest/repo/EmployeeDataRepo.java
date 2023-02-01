package az.code.studentdbrest.repo;

import az.code.studentdbrest.models.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeDataRepo extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e where  e.name = :name")
    List<Employee> findByName(String name, Pageable pageable);
}
