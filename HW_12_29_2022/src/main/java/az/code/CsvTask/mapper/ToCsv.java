package az.code.CsvTask.mapper;

import az.code.CsvTask.model.Person;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ToCsv {
    public static void writePerson(List<Person> personList, String file) {
        StringBuilder builder = new StringBuilder();
        builder.append("NAME_SURNAME,AGE,COURSE\n");
        personList.forEach(e -> builder.append(e.toCSV()));
        write(builder, file);
    }

    public static void write(StringBuilder str, String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);

            fileWriter.write(str.toString());

            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

