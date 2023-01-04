package az.code.CsvTask.mapper;

import az.code.CsvTask.annotation.Csv;
import az.code.CsvTask.annotation.CsvColumn;
import az.code.CsvTask.model.Person;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CsvMapper {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Person person = new Person();
        int i = 0;
        if (person.getClass().isAnnotationPresent(Csv.class)) {
            for (Field field : person.getClass().getDeclaredFields()) {

                if (field.isAnnotationPresent(CsvColumn.class)) {
                    CsvColumn csvColumn = field.getAnnotation(CsvColumn.class);

                    String name = field.getName();
                    name = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
                    Method method = Person.class.getMethod(name, String.class);
                    method.invoke(person, csvColumn.name() + "-" + i++);

                    field.setAccessible(true);//private fieldlere mudaxile

                    field.set(person, csvColumn.name() + "-" + i++);

                }
            }
        }
        System.out.println(person);
    }
}
