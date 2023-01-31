package com.example.dao;

import com.example.entity.Employee;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeDao {

    private final EntityManager entityManager;

    public Employee updateEmpoyee(){
        return null;
    }
}
