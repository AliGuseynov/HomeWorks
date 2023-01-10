package az.code.CsvTask.mapper;

import az.code.CsvTask.annotation.Csv;
import az.code.CsvTask.annotation.CsvColumn;
import az.code.CsvTask.model.Person;

import java.io.IOException;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvMap {
    private static int firstLineIndex = 0;

    public List<Person> parse(Path path, Class<Person> personClass) throws IOException {
        List<List<String>> lines = Files.readAllLines(path)
                .stream()
                .map(line -> Arrays.asList(line.split(",")))
                .collect(Collectors.toList());

        if (lines.size() > 0) {
            Map<Integer, Field> header = getHeaders(personClass, lines.get(firstLineIndex));
            return lines.subList(firstLineIndex + 1, lines.size() - 1)
                    .stream()
                    .map(line -> getPerson(personClass, header, line))
                    .collect(Collectors.toList());
        }

        return Collections.emptyList();
    }


    public Map<Integer, Field> getHeaders(Class<Person> personClass, List<String> firstLine) {

       final Map<Integer, Field> map = new HashMap<>();
        Stream.of(personClass.getDeclaredFields())
                .filter(field -> field.getAnnotation(CsvColumn.class) != null)
                .forEach(field -> {
                    CsvColumn csvColumn = field.getAnnotation(CsvColumn.class);
                    String columnName = csvColumn.column().trim();
                    int columnIndex = firstLine.indexOf(columnName);
                    map.put(columnIndex, field);

                });
        return map;
    }


    public Person getPerson(Class<Person> personClass, Map<Integer, Field> header, List<String> line) {

        try {
            Person obj = personClass.getDeclaredConstructor()
                    .newInstance();

            for (int index = 0; index < line.size(); index++) {
                Field field = header.get(index);
                String fieldName = field.getName();
                Optional<Method> setter = getSetterMethod(obj, fieldName);

                if (setter.isPresent()) {
                    Method setMethod = setter.get();
                    setMethod.invoke(obj, line.get(index));
                }
            }

            return obj;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Optional<Method> getSetterMethod(Person person, String fieldName) {

        return Arrays.stream(person.getClass()
                        .getDeclaredMethods())
                .filter(method -> method.getName()
                        .equals("set" + fieldName.substring(0, 1)
                                .toUpperCase()
                                + fieldName.substring(1)))
                .findFirst();


    }

}
