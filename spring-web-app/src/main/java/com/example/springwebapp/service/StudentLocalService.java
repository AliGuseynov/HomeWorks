package com.example.springwebapp.service;

import com.example.springwebapp.dto.StudentDto;

import java.util.List;

public class StudentLocalService implements ServiceInter{
    @Override
    public void update(long id, StudentDto studentDto) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void save(StudentDto studentDto) {

    }

    @Override
    public List<StudentDto> sort(String name, String sorType) {
        return null;
    }

    @Override
    public List<StudentDto> searchBySurname(String surname) {
        return null;
    }

    @Override
    public List<StudentDto> searchByName(String name) {
        return null;
    }

    @Override
    public List<StudentDto> getAll() {
        return null;
    }
}
