package az.code.Mapping.mapper;

import az.code.Mapping.annotations.Csv;
import az.code.Mapping.annotations.CsvColumn;
import models.Student;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class CsvMapper {
    public static Student CsvMap(String[] studentDetails, HashMap<String, Integer> columns) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Student s = new Student();

        if(s.getClass().isAnnotationPresent(Csv.class)){
            for(Field f : Student.class.getDeclaredFields()){
                if(f.isAnnotationPresent(CsvColumn.class)){
                    CsvColumn columnAnnotation = f.getAnnotation(CsvColumn.class);
                    String name = f.getName();
                    name = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
                    Method method = Student.class.getMethod(name, String.class);
                    if (columns.containsKey(f.getName())){
                        method.invoke(s, columns.get(f.getName()));
                    } else {
                        //throw new ColumnNotFoundException();
                    }
                }
            }
        }
        return s;
    }
}


