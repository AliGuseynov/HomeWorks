package models;

import az.code.Mapping.annotations.Csv;
import az.code.Mapping.annotations.CsvColumn;
import lombok.*;

@Csv
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @CsvColumn(name = "ID")
    private Long id;
    @CsvColumn(name = "name")
    private String name;
    @CsvColumn(name = "surname")
    private String surname;
    @CsvColumn(name= "age")
    private int age;


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + getName() + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
