package org.example;
import lombok.*;
import org.example.az.code.annotations.Csv;
import org.example.az.code.annotations.CsvColumn;

@Csv
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@Getter
@Setter
public class Student {
    //    @CsvColumn(name = "ID")
    private int id;
    @CsvColumn(name = "alias", surname = "")
    private String name;
    @CsvColumn(name="",surname = "surname")
    private String surname;
   private int age;

    public Student(int id, String name, String surname, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
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
