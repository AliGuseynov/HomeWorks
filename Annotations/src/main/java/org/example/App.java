package org.example;

import org.example.models.Car;

import lombok.extern.java.Log;
import org.example.models.CsvMapper;
import org.example.models.FileReader;
import org.example.models.FileWriter;

import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {


//        List<Car> carsList = new ArrayList<>();
//        Car bmw = Car.builder().manufacturer("bmw").model("320").engineSize("2000").productionYear(1995).build();
//        carsList.add(bmw);
//        carsList.add(new Car("BMW","330", 2004, "3000"));
//        carsList.add(new Car("BMW","540", 2004, "4400"));
//        carsList.add(new Car("Mercedes","e500", 1996, "5000"));
//
////         Task object to CSV
//        FileWriter.writeCars(carsList, "files\\carsExport.csv");

        // Task CSV to object
//        FileReader.readFile("files\\carsExport.csv");


        // Hanoi tower task
        HanoiTower.towerOfHanoi(8, 'A','C','B');
    }
}
