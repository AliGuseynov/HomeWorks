package az.code.DataToExcel;

import az.code.DataToExcel.model.CsvToExcel;
import az.code.DataToExcel.model.FileReading;
import az.code.DataToExcel.model.Store;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;


import static az.code.DataToExcel.model.CsvToExcel.fileReading;

public class Main {
    public static void main(String[] args) throws IOException {


        FileReading.readFile("C:\\CsvToXlsx\\files\\data.csv");

//        List<List<String>> file = fileReading(fileName);
//        CsvToExcel.WriteDataToExcel(file);

//        System.out.println(file);

//        List<Store> stores = FileReading.readFile(fileName);
//        System.out.println(stores);
    }


}

