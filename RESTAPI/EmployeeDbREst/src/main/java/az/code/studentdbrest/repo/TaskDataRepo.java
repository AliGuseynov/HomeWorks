package az.code.studentdbrest.repo;

import az.code.studentdbrest.models.Employee;
import az.code.studentdbrest.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDataRepo extends JpaRepository<Task, Long> {
}
