package az.code.DataToExcel;

import az.code.DataToExcel.model.CsvToExcel;
import az.code.DataToExcel.model.FileReading;
import az.code.DataToExcel.model.Store;

import java.io.IOException;



public class Main {
    public static void main(String[] args) throws IOException {


        FileReading.readFile("C:\\CsvToXlsx\\files\\data.csv");

//        List<List<String>> file = fileReading(fileName);
//        CsvToExcel.WriteDataToExcel(file);


    }


}

