package az.code.CsvTask;

import az.code.CsvTask.mapper.CsvMap;
import az.code.CsvTask.mapper.ToCsv;
import az.code.CsvTask.model.Person;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.List;

import static javax.print.attribute.standard.MediaSizeName.C;

public class Main {
    public static void main(String[] args) throws IOException {
//        Person person = Person.builder()
//                .fullName("leyla khalilli")
//                .age(21)
//                .course("java")
//                .build();


//        List<Person> personList = readPerson("C:\\CodeAcademyBootCamp\\Files\\forCSVTask.txt");

//        System.out.println("??????????");
//        for (Person person : personList) {
//            System.out.println(person);
//        }


        CsvMap csvMap = new CsvMap();
        List<Person> people = csvMap.parse(Paths.get("C:\\JavaCodeAcademy\\HW_12_29_2022\\person.csv"), Person.class);
        System.out.println(people);

//        ToCsv.writePerson(people, "C:\\JavaCodeAcademy\\HW_12_29_2022\\toCSV.csv");
    }
}
