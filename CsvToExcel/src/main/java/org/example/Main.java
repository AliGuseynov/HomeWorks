package org.example;

import org.example.config.Config;
import org.example.converter.CsvToObject;
import org.example.converter.ObjectToExcel;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

//        String fileName = "C:\\Users\\user\\IdeaProjects\\CsvToExcel\\src\\main\\data.txt";
//        ObjectToExcel.writeToExcel(
//               fileName,CsvToObject.readAllDatasFromCSV(fileName)
//        );
        String fileName = "C:\\Users\\user\\IdeaProjects\\CsvToExcel\\src\\main\\data.txt";

        System.out.println(CsvToObject.createClients(fileName));
        System.out.println(Config.excelSheet(CsvToObject.readAllDatasFromCSV(fileName),CsvToObject.createClients(fileName)));
        System.out.println(Config.amountAdder(CsvToObject.createClients(fileName), CsvToObject.readAllDatasFromCSV(fileName)));
        ObjectToExcel.writeToExcel(fileName,CsvToObject.readAllDatasFromCSV(fileName));
    }
}