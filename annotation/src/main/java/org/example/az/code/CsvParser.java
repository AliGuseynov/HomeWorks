package org.example.az.code;

import org.example.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CsvParser {
    public static void main(String[] args) throws IOException {
        List<Student> students = readStudentsFromCSV("data.csv");
        for (Student s : students) {
            System.out.println(s);
        }
    }
    public static List<Student> readStudentsFromCSV(String fileName) throws IOException {
        List<Student> students = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        BufferedReader br = Files.newBufferedReader(pathToFile);
        String line ="";
        int iteration=0;

        while ((line = br.readLine()) != null) {
            if(iteration == 0) {
                iteration++;
                continue;
            }
            String[] attributes = line.split(",");
            Student student = createStudent(attributes);
            students.add((Student) student);
        }
        return students;
    }

    private static Student createStudent(String[] metadata) {
        String name = metadata[1];
        String surname = metadata[2];
        int id = Integer.parseInt((metadata[0]));
        int age = Integer.parseInt((metadata[3]));
        return new Student(id, name, surname, age);
    }

}
