package az.code.mapper;

import az.code.annotations.Csv;
import az.code.annotations.CsvColumn;
import models.Student;

import java.awt.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CsvMapper {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Student s = new Student();
        int i = 0;

        if(s.getClass().isAnnotationPresent(Csv.class)){

            for(Field f : Student.class.getDeclaredFields()){
                if(f.isAnnotationPresent(CsvColumn.class)){
                    CsvColumn columnAnnotation = f.getAnnotation(CsvColumn.class);
                    String name = f.getName();
                    name = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
                    Method method = Student.class.getMethod(name, String.class);
                    method.invoke(s, columnAnnotation.name() + "-" + i++);

//                    f.setAccessible(true);
//                    if(f.getType().equals(Long.class)){
//                        f.set(s,Long.valueOf(i++));
//                    }else{
//                        f.set(s, columnAnnotation.name() + "-" + i++);
//                    }

                }
            }
        }
        System.out.println(s);
    }
}