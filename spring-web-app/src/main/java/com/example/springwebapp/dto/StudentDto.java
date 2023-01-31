package com.example.springwebapp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class StudentDto {
   private Long id;
   private String name;
    private String surname;

}
