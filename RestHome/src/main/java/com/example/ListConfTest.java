package com.example;

import com.example.dto.EmployeeDto;

import java.util.List;
import java.util.stream.Collectors;

public class ListConfTest {


    public static void main(String[] args) {
        List<EmployeeDto> employeeDtoList = CreateList.createList();
        int a = 1;
        List<EmployeeDto> b = employeeDtoList.stream().filter(employee -> employee.getId() == 2).collect(Collectors.toList());
        b.forEach(System.out::println);
    }
}
