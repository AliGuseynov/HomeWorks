package az.code.CsvTask.model;

import az.code.CsvTask.annotation.Csv;
import az.code.CsvTask.annotation.CsvColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Csv
public class Person {
    @CsvColumn(column = "NAME_SURNAME")
    private String fullName;

    @CsvColumn(column = "AGE")
    private String age;

    @CsvColumn(column = "COURSE")
    private String course;

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", course='" + course + '\'' +
                '}';
    }

    public String toCSV(){
        return fullName + "," + age + "," + course + ",,\n";
    }

}