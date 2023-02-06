package com.example.springwebapp.repo;

import com.example.springwebapp.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepoitory extends JpaRepository<Task,Long> {
}
