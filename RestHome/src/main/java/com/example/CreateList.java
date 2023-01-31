package com.example;

import com.example.dto.EmployeeDto;
import com.example.entity.Task;

import java.util.List;

public class CreateList {
    public static List<EmployeeDto> createList(){
        return List.of(EmployeeDto.builder()
                .id(1)
                .name("Name1")
                .surName("Surname1")
                .taskList(List.of(Task.builder().id(1).title("Title1.1").description("Description1.1").dueDate("01-01-1").build(),
                        Task.builder().id(2).title("Title1.2").description("Description1.2").dueDate("02-01-1").build()))
                .build(),
                EmployeeDto.builder()
                        .id(2)
                        .name("Name2")
                        .surName("Surname2")
                        .taskList(List.of(Task.builder().id(1).title("Title2.1").description("Description2.1").dueDate("01-02-1").build(),
                                Task.builder().id(2).title("Title2.2").description("Description2.2").dueDate("02-02-1").build()))
                        .build(),
                EmployeeDto.builder()
                        .id(3)
                        .name("Name3")
                        .surName("Surname3")
                        .taskList(List.of(Task.builder().id(1).title("Title3.1").description("Description3.1").dueDate("01-03-1").build(),
                                Task.builder().id(2).title("Title3.2").description("Description3.2").dueDate("02-03-1").build()))
                        .build(),
                EmployeeDto.builder()
                        .id(4)
                        .name("Name4")
                        .surName("Surname4")
                        .taskList(List.of(Task.builder().id(1).title("Title4.1").description("Description4.1").dueDate("01-04-1").build(),
                                Task.builder().id(2).title("Title4.2").description("Description4.2").dueDate("02-04-1").build()))
                        .build(),
                EmployeeDto.builder()
                        .id(5)
                        .name("Name5")
                        .surName("Surname5")
                        .taskList(List.of(Task.builder().id(1).title("Title5.1").description("Description5.1").dueDate("01-05-1").build(),
                                Task.builder().id(2).title("Title5.2").description("Description5.2").dueDate("02-05-1").build()))
                        .build()
               );
    };
}
