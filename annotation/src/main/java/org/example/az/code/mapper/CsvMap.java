package annotation.src.main.java.org.example.az.code.mapper;

import org.example.Student;
import org.example.az.code.annotations.Csv;
import org.example.az.code.annotations.CsvColumn;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvMap {
    public static void main(String[] args) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Student s = new Student();

        if (s.getClass().isAnnotationPresent(Csv.class)) {
            int i = 0;
            List<Student> students = readStudentsFromCSV("data.csv");
//            for (Student a : students) {
//                System.out.println(a);
//            }
            for (Field f : Student.class.getDeclaredFields()) {
                if (f.isAnnotationPresent(CsvColumn.class)) {
                    CsvColumn columnAnnotation = f.getAnnotation(CsvColumn.class);
                    String name = f.getName();
                }
                i++;
            }
        }
    }

    public static List<Student> readStudentsFromCSV(String fileName) throws IOException {
        List<Student> students = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        BufferedReader br = Files.newBufferedReader(pathToFile);
        String line = "";
        int iteration = 0;

        while ((line = br.readLine()) != null) {
            if (iteration == 0) {
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