package az.code.mapper;

import az.code.annotations.Csv;
import az.code.annotations.CsvColumn;
import models.Student;

import java.awt.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CsvMapper {
    public static void foo() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Student s = new Student();
        int i = 0;
        if (s.getClass().isAnnotationPresent(Csv.class)) {
            for (Field f : Student.class.getDeclaredFields()) {
                if (f.isAnnotationPresent(CsvColumn.class)) {
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

    public Student setELement(Student s,Student student) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Student student1=s;
        Student student2=student;
        if (s.getClass().isAnnotationPresent(Csv.class)) {
            for (Field f : Student.class.getDeclaredFields()) {
                if (f.isAnnotationPresent(CsvColumn.class)) {
                    CsvColumn columnAnnotation = f.getAnnotation(CsvColumn.class);
                    String fieldName = f.getName();
                    fieldName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    System.out.println(fieldName);
                    getAllMethods(student1,student2);
                }
            }
        }
       return  s;
    }
    public static void getAllMethods(Student s,Student student){
        Method[] method = Student.class.getMethods();
        for (int i = 0; i < method.length; i++) {
            if (method[i].getName().equals("setId")) {
                s.setId(student.getId());
            } else if (method[i].getName().equals("setName")) {
                s.setName(student.getName());
            } else if (method[i].getName().equals("setSurname")) {
                s.setSurname(student.getSurname());
            } else if (method[i].getName().equals("setAge")) {
                s.setAge(student.getAge());
            }
        }
    }
//    public static List<Student> createCsvDataSimple(){

//    }

}
