package com.example.dto;

import com.example.entity.Task;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class EmployeeDto {

    private int id;
    private String name;
    private String surName;
    private List<Task> taskList;
}
