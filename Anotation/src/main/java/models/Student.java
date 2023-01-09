package models;

import az.code.annotations.Csv;
import az.code.annotations.CsvColumn;
import lombok.*;

import java.io.Serializable;

@Csv
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {
    @CsvColumn
    private Long id;
    @CsvColumn(name = "alias")
    private String name;
    @CsvColumn(name="surname")
    private String surname;
    private int age;


    @Override
    public String toString() {
        return
                "id" +
                ", name"+
                ", surname"  +
                ", age"+"\n"+id+","+name+","+surname+","+age;
    }
}
