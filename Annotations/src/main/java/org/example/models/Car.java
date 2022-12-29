package org.example.models;

import lombok.*;
import org.example.annotations.Csv;
import org.example.annotations.CsvColumn;

@Csv
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @CsvColumn
    private String manufacturer;
    @CsvColumn
    private String model;
    private int productionYear;
    @CsvColumn
    private String engineSize;


    public String toCSV(){
        return null + "," +manufacturer + "," + model + "," + engineSize + ",,\n";
    }


}
