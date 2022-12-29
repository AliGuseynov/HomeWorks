package org.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Csv
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    //    @CsvColumn(name = "ID")
    private Long id;
    @CsvColumn(name = "alias")
    private String name;
    @CsvColumn
    private String surname;
    int age;

    public String getName() {
        return name + name;
    }

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
