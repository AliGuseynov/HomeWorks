package com.reader.student;

import java.util.Collections;
import java.util.List;

public class StudentConfig<T> {

    public static List<Student> sortStudent(List<Student> studentList){
        Collections.sort(studentList);
        return studentList;
        // Burda ortadaki elementi koplayiyir idk niye
    }

    public static <T> Student searchStudent(List<Student> studentList,T element){
        Student result = null;
        if (element instanceof String){
            for (Student student : studentList){
                if (student.getName().equals(element)){
                    result = student;
                }
            }
        }
        if (element instanceof Integer){
            for (Student student : studentList){
                if (element.equals(studentList.getId)){
                    result = student;
                    //Bunada sabahda zadda baxacam bele ishletmek ucun commente alin
                }
            }
        }
        return result;
    }
}
