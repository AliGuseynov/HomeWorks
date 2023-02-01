package com.example.demoemployeecrud.repo;

import com.example.demoemployeecrud.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity,Long> {
}
