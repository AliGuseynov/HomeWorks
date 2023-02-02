package az.code.springwebdemo.repo;

import az.code.springwebdemo.model.Employee;
import az.code.springwebdemo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
