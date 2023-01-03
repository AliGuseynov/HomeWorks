package org.example.convertfile;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.models.Address;
import org.example.models.Student;
import org.example.models.Subject;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class POJOToJSON {
    public static void PojoToObjectAndBack() throws IOException {
        List<Subject> list = new ArrayList<>();
        Subject subject = new Subject(1, "Java");
        list.add(subject);
        Address address = new Address(1, "Baku", "Meshedi 22", LocalDate.of(2023,1,1));
        Student std = new Student(1, "Nihad", address, LocalDate.of(2023,1,3), list);
        ObjectMapper mapper = new ObjectMapper();
        mapper. writeValue(new File("C:\\CodeAcademyTask\\HomeWorks\\XMLJSONFile\\student.json"), std);
        Student student=mapper.readValue(new File("C:\\CodeAcademyTask\\HomeWorks\\XMLJSONFile\\student.json"),Student.class);
        System.out.println(student);
    }
}
