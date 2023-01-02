package az.code.HW12_29_2022.taskCSV.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
    private String fullName;
    private int age;
    private String course;

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", course='" + course + '\'' +
                '}';
    }
}
