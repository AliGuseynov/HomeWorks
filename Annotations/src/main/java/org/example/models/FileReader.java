package org.example.models;

import org.example.exceptions.ColumnNotFoundException;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FileReader {


    public static void readFile(String fileLocation){
        String strOut = null;
        File file = new File(fileLocation);
        try (Scanner scanner = new Scanner(file);){

            HashMap<String, Integer> csvKeys = getCsvKeys(scanner.nextLine()); // we are getting column names here

            while (scanner.hasNextLine()) {
                        String data = scanner.nextLine();
                        String[] attS = data.split(",");

                    System.out.println(CsvMapper.mapCar(attS,csvKeys));

            }
            } catch (ColumnNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException | FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static HashMap<String, Integer> getCsvKeys(String line){
        HashMap<String, Integer> tempHashmap = new HashMap<>();
        String[] cols = line.split(",");
        for (int i = 0; i<cols.length; i++){
            tempHashmap.put(cols[i], i);
        }
        return tempHashmap;
    }


}
