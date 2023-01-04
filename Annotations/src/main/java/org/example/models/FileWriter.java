package org.example.models;

import java.io.IOException;
import java.util.List;

public class FileWriter {

    public static void writeCars(List<Car> cars, String file){
        StringBuilder str = new StringBuilder();
        str.append("id,manufacturer,model,engineSize,productionCountry,driveWheels\n");
//        cars.forEach(a-> str.append(a.toCSV()));
        cars.forEach(a-> str.append(CsvMapper.carToCSV(a)));
        writeToFile(str, file);
    }

    public static void writeToFile(StringBuilder str, String filename){

        try {
            java.io.FileWriter myWriter = new java.io.FileWriter(filename);

            myWriter.write(str.toString());

            myWriter.flush();
            myWriter.close();
            System.out.println("Files written");

        } catch (IOException e) {
            System.out.println("File error");}
    }
}
