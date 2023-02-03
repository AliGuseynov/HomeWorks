package com.example.repo;

import com.example.entity.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskCrudRepository extends CrudRepository<Task,Integer> {
}
