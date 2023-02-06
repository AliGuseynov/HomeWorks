package com.example.springwebapp.repo;

import com.example.springwebapp.entity.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByNameAndSurname(String name,String surname);
    //List<Student> findByLastName(String lastName, Sort sort);
}
