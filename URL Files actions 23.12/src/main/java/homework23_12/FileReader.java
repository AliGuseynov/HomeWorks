package homework23_12;

import homework23_12.Classes.Student;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.util.Scanner;

public class FileReader {


    public static List<Student> readStudentFile(String fileLocation){

        int scenario = 0;
        if (fileLocation.contains(".json")){
            scenario = 1;
        } else if (fileLocation.contains(".xml")) {
            scenario = 2;
        }else if (fileLocation.contains(".csv")) {
            System.out.println("CSV file detected");
            scenario = 3;
        }

        return readFile(fileLocation, scenario);

    }

    public static List<Student> readFile(String filePath, int scenario){
        String strOut = null;
        List<Student> studentList = new ArrayList<>();
        try {
            File file = new File(filePath);

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                switch (scenario){
                    case 1:  // JSON
                        String data = scanner.nextLine();
                        System.out.println(data);
                        String[] attributes = data.split(",");
                        studentList.add(createStudentObject(attributes));
                        strOut = strOut+data;
                        break;
                    case 2: //XML
                        break;
                    case 3: //CSV
                        data = scanner.nextLine();
                        String[] attS = data.split(",");
                        studentList.add(createStudentObject(attS));
//                        System.out.println(studentFromCSV(attS));
//                        strOut = strOut+data;
                        break;
                }
            //                System.out.println(data);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file");
            e.printStackTrace();
        }
        return studentList;
    }

    private static Student createStudentObject(String[] attributes){

        Student stOut = new Student(Integer.parseInt(attributes[0]), attributes[1],attributes[2], LocalDate.parse(attributes[3]));
        return stOut;
    }


}
