package com.example.springwebapp.service;

import com.example.springwebapp.dto.StudentDto;
import com.example.springwebapp.repo.StudentDaoList;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Profile("prod")
public class StudentService implements ServiceInter {

    private List<StudentDto> daolist = StudentDaoList.createList();

    @Override
    public List<StudentDto> getAll() {
        return daolist;
    }

    @Override
    public List<StudentDto> searchByName(String name) {//ve ya mentiqi alinmadi
        List<StudentDto> list = daolist.stream().
                filter(e -> e.getName().equals(name))
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public List<StudentDto> searchBySurname(String surname) {
        List<StudentDto> list = daolist.stream().
                filter(e -> e.getSurname().equals(surname))
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public List<StudentDto> sort(String name, String sorType) {
        if (sorType.equals("asc")) {
            List<StudentDto> list = daolist.stream().
                    filter(e -> e.getName().equals(name))
                    .sorted(Comparator.comparing(StudentDto::getName))
                    .collect(Collectors.toList());

            return list;
        } else if (sorType.equals("desc")) {
            List<StudentDto> list = daolist.stream().
                    filter(e -> e.getName().equals(name))
                    .sorted(Comparator.comparing(StudentDto::getName))
                    .collect(Collectors.toList());
            Collections.reverse(list);
            return list;
        }
        return null;
    }

    @Override
    public void save(StudentDto studentDto) {
        daolist.add(StudentDto.builder().
                id(studentDto.getId()).
                name(studentDto.getName()).surname(studentDto.getSurname()).build());
    }

    @Override
    public void delete(long id) {
        StudentDto st = daolist.stream().filter(x -> x.getId().equals(id)).findAny().get();
        daolist.remove(st);
    }

    @Override
    public void update(long id, StudentDto studentDto) {
        StudentDto st = daolist.stream().filter(x -> x.getId().equals(id)).findAny().get();
        daolist.remove(st);
        st.setId(studentDto.getId());
        st.setName(studentDto.getName());
        st.setSurname(studentDto.getSurname());
        daolist.add(st);
    }
}
