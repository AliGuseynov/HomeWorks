package com.example.springwebapp.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
public class TaskDto {
   private Long id;
   private String description;
   private Date dueDate;

   @Override
   public String toString() {
      return "TaskDto{" +
              "id=" + id +
              ", description='" + description + '\'' +
              ", dueDate=" + dueDate +
              '}';
   }
}
