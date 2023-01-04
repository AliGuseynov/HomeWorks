package az.code.CsvTask;

import az.code.CsvTask.model.Person;

import java.util.List;

import static az.code.CsvTask.file.FileReader.readPerson;

public class Main {
    public static void main(String[] args) {
//        Person person = Person.builder()
//                .fullName("leyla khalilli")
//                .age(21)
//                .course("java")
//                .build();


        List<Person> personList = readPerson("C:\\CodeAcademyBootCamp\\Files\\forCSVTask.txt");

//        System.out.println("??????????");
//        for (Person person : personList) {
//            System.out.println(person);
//        }

    }
}
