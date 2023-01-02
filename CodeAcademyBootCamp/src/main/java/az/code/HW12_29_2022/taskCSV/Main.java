package az.code.HW12_29_2022.taskCSV;


import az.code.HW12_29_2022.taskCSV.model.Person;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Person> readPerson(String filename) {
        List<Person> personList = new ArrayList<>();

        Path path = Paths.get(filename);

        try (BufferedReader bufferedReader = Files.newBufferedReader(path, StandardCharsets.US_ASCII)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] prsn = line.split(",");
                Person person = createPerson(prsn);


                personList.add(person);


                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return personList;

    }


    public static Person createPerson(String[] data) {
        String fullName = data[0];
        int age = Integer.parseInt(data[1]);
        String course = data[2];

        return new Person(fullName, age, course);
    }


    public static void main(String[] args) {
        List<Person> personList = readPerson("C:\\CodeAcademyBootCamp\\Files\\forCSVTask.txt");

//        System.out.println("??????????");
        for (Person person : personList) {
            System.out.println(person);
        }

    }
}
