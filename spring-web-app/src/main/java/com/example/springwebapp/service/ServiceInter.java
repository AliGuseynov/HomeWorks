package com.example.springwebapp.service;

import com.example.springwebapp.dto.StudentDto;

import java.util.List;

public interface ServiceInter {
    void update(long id, StudentDto studentDto);

    void delete(long id);

    void save(StudentDto studentDto);

    List<StudentDto> sort(String name, String sorType);

    List<StudentDto> searchBySurname(String surname);

    List<StudentDto> searchByName(String name);

    List<StudentDto> getAll();
}
