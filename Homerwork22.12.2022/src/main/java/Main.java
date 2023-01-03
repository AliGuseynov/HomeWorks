import az.code.Task1.RecordAdapter;
import az.code.Task2.XMLtoJSON;
import az.code.Task3.FindFile;
import org.json.JSONObject;
import org.json.XML;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) throws IOException {

                //TASK1

        RecordAdapter adapter = new RecordAdapter();
        adapter.readFileToList("input.txt");
        System.out.println(adapter.getCarNumberList());
        System.out.println("\nDates:");
        System.out.println(adapter.getDateList());
        System.out.println("\nNumbers:");
        System.out.println(adapter.getIntNumberList());
        System.out.println("\nFree text:");
        System.out.println(adapter.getFreeTextList());
        adapter.writeToFile();

                //TASK2
//        XMLtoJSON obj = new XMLtoJSON();
//        obj.xmlToJson();

            //TASK3

//            FindFile ff = new FindFile();
//            Scanner scan = new Scanner(System.in);
//            System.out.println("Enter the file to be searched.. " );
//            String name = scan.next();
//            System.out.println("Enter the directory where to search ");
//            String directory = scan.next();
//            ff.findFile(name,new File(directory));
  }
}