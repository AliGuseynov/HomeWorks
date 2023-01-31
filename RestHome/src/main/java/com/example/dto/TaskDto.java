package com.example.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskDto {

    private int id;
    private String title;
    private String description;
    private String dueDate;

}
