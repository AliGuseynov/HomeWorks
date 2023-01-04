package az.code.CsvTask.file;

import az.code.CsvTask.model.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

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
}
