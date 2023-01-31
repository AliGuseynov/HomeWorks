package com.example.springwebapp.repo;

import com.example.springwebapp.dto.StudentDto;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoList {

    public static List<StudentDto> createList() {
        List<StudentDto> list = new ArrayList<>();
        list.add(StudentDto.builder().id(1L).name("Nezrin").surname("Suleymanli").build());
        list.add(StudentDto.builder().id(2L).name("Leyla").surname("Suleymanov").build());
        list.add(StudentDto.builder().id(3L).name("Serxan").surname("Suleymanli").build());
        list.add(StudentDto.builder().id(4L).name("Suleyman").surname("Suleymanov").build());
        list.add(StudentDto.builder().id(55L).name("Nezrin").surname("Salmanova").build());
        list.add(StudentDto.builder().id(5L).name("Nermin").surname("Aliyeva").build());
        list.add(StudentDto.builder().id(6L).name("Hakim").surname("Atakishiyev").build());
        list.add(StudentDto.builder().id(7L).name("Mahir").surname("Suleymanov").build());
        list.add(StudentDto.builder().id(8L).name("Nicat").surname("Ahmedov").build());
        list.add(StudentDto.builder().id(45L).name("Nezrin").surname("Haciyeva").build());
        return list;
    }

}
