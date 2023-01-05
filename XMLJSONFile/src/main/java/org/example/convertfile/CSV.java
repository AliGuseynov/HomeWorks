package org.example.convertfile;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.example.models.Address;
import org.example.models.Student;
import org.example.models.Subject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSV {
    public static void writeToCsvFile() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        List<Subject> list = new ArrayList<>();
        Subject subject = new Subject(1, "Java");
        list.add(subject);
        Address address = new Address(1, "Baku", "Meshedi 22", LocalDate.of(2023, 1, 1));
        Student std = new Student(1, "Nihad", address, LocalDate.of(2023, 1, 3), list);
        List<Student> students = new ArrayList<>();
        students.add(std);
        ColumnPositionMappingStrategy mappingStrategy = new ColumnPositionMappingStrategy();
        mappingStrategy.setType(Student.class);
        String[] columns = new String[]{"id", "Name", "Address", "Localdate", "Subjects"};
        mappingStrategy.setColumnMapping(columns);
        FileWriter writer = new FileWriter("C:\\CodeAcademyTask\\HomeWorks\\XMLJSONFile\\student.csv");
        StatefulBeanToCsvBuilder<Student> builder = new StatefulBeanToCsvBuilder(writer);
        StatefulBeanToCsv beanWriter = builder.withMappingStrategy(mappingStrategy).build();
        beanWriter.write(students);
        writer.close();
    }
    public static void readFromCsvFile(){

        String fileName = "C:\\CodeAcademyTask\\HomeWorks\\XMLJSONFile\\student.csv";
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            List<String[]> r = reader.readAll();
            r.forEach(x -> System.out.println(Arrays.toString(x)));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
