package com.reader.converter;

import com.reader.student.Address;
import com.reader.student.Student;
import com.reader.student.StudentConfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileToObject {

    public static void main(String[] args) throws IOException {
        List<Student> studentList = readFromCSV(
                "C:\\Users\\user\\IdeaProjects\\csvreader\\csvreader\\src\\main\\students.txt"
        );
        for (Student s : studentList){
            System.out.println(s);
        }

    }

    private static Student createStudentFromFile(String[] elements){
        int id = Integer.parseInt(elements[0]);
        String name = elements[1];
        int addressId = Integer.parseInt(elements[2]);
        String street = elements[3];
        String city = elements[4];
        LocalDate localDate = LocalDate.parse(elements[5]);
        LocalDate creationDate = LocalDate.parse(elements[6]);

        return new Student(id,name,new Address(addressId,street,city,localDate),creationDate);
    }

  public static List<Student> readFromCSV(String fileName) throws IOException {
      List<Student> studentList = new ArrayList<>();
      Path path = Paths.get(fileName);

      BufferedReader bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
      String line = bufferedReader.readLine();

      while (line!=null){
            String[] elements = line.split(",");
            Student student = createStudentFromFile(elements);
            studentList.add(student);
            line=bufferedReader.readLine();
      }
      return studentList;
  }

}
