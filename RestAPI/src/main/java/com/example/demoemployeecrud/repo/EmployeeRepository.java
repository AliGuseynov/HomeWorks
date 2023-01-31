package com.example.demoemployeecrud.repo;

import com.example.demoemployeecrud.entities.EmployeeEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

    @Query("SELECT e FROM EmployeeEntity e where  e.name = :name")
    List<EmployeeEntity> findByName(String name, Pageable pageable);
}
