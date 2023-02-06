package com.example.springwebapp.memory;

import com.example.springwebapp.dto.StudentDto;
import com.example.springwebapp.dto.TaskDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//public class StudentList {
//    public static List<StudentDto> createList() {
//
//        List<TaskDto> taskList=new ArrayList<>();
//        taskList.add(TaskDto.builder().id(1L).description("task1").dueDate(LocalDate.parse("2023-02-02")).build());
//        taskList.add(TaskDto.builder().id(2L).description("task3").dueDate(LocalDate.parse("2023-03-02")).build());
//        taskList.add(TaskDto.builder().id(3L).description("task4").dueDate(LocalDate.parse("2023-05-02")).build());
//        List<StudentDto> list = new ArrayList<>();
//        list.add(StudentDto.builder().id(1L).name("Nezrin").surname("Suleymanli").tasks(taskList).build());
//        list.add(StudentDto.builder().id(2L).name("Leyla").surname("Suleymanov").tasks(taskList).build());
//        list.add(StudentDto.builder().id(3L).name("Serxan").surname("Suleymanli").tasks(taskList).build());
//        list.add(StudentDto.builder().id(4L).name("Suleyman").surname("Suleymanov").tasks(taskList).build());
//        list.add(StudentDto.builder().id(55L).name("Nezrin").surname("Salmanova").tasks(taskList).build());
//        list.add(StudentDto.builder().id(5L).name("Nermin").surname("Aliyeva").tasks(taskList).build());
//        list.add(StudentDto.builder().id(6L).name("Hakim").surname("Atakishiyev").tasks(taskList).build());
//        list.add(StudentDto.builder().id(7L).name("Mahir").surname("Suleymanov").tasks(taskList).build());
//        list.add(StudentDto.builder().id(8L).name("Nicat").surname("Ahmedov").tasks(taskList).build());
//        list.add(StudentDto.builder().id(45L).name("Nezrin").surname("Haciyeva").tasks(taskList)
//                .build());
//        return list;
//    }
//
//}
