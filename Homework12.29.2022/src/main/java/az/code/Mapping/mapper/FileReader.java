package az.code.Mapping.mapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class FileReader {
    public static void main(String[] args) throws FileNotFoundException {
        File studentFile = new File("student.csv");
        Scanner studentScanner = new Scanner(studentFile);
        try{
            HashMap<String, Integer> columnNames = getColumnNames(studentScanner.nextLine());
            while (studentScanner.hasNextLine()) {

                String nextLine = studentScanner.nextLine();

                String[] students = nextLine.split(",");

                System.out.println(CsvMapper.CsvMap(students, columnNames));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static HashMap<String, Integer> getColumnNames(String line){
        HashMap<String, Integer> tempHashmap = new HashMap<>();
        String[] cols = line.split(",");
        for (int i = 0; i<cols.length; i++){
            tempHashmap.put(cols[i], i);
        }
        return tempHashmap;
    }

}
