package homework23_12;

import homework23_12.Classes.Student;
import org.json.JSONObject;
import org.json.XML;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Seeder {

    public static void generateStudentFiles(){
        List<Student> students = new ArrayList<>();

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate startDate = LocalDate.parse("01/01/1995", format);
        LocalDate endDate = LocalDate.parse("31/12/2010", format);

        students.add(new Student(0,"John", "Smith", randomdate(startDate, endDate)));
        students.add(new Student(1,"Vaqif", "Cavadov", randomdate(startDate, endDate)));
        students.add(new Student(2,"Margot", "Robbie", randomdate(startDate, endDate)));
        students.add(new Student(3,"Ragnar", "Lothbrok", randomdate(startDate, endDate)));
        students.add(new Student(4,"Vin", "Diesel", randomdate(startDate, endDate)));

//        students.forEach(System.out::println);

        writeToJson(students);
        writeToCSVFile(students);
        writeToXMlFile(students);
    }


    public static void writeToFile(StringBuilder str, String filename){

        try {
            FileWriter myWriter = new FileWriter("files\\StudentsTask\\" + filename);

            myWriter.write(str.toString());

            myWriter.flush();
            myWriter.close();
            System.out.println("Files written");

        } catch (IOException e) {
            System.out.println("File error");}
    }

    public static void write(String str, String filename){
        try {
            FileWriter myWriter = new FileWriter(filename);

            myWriter.write(str);

            myWriter.flush();
            myWriter.close();
            System.out.println("Files written");

        } catch (IOException e) {
            System.out.println("File error");}

    }

    private static LocalDate randomdate(LocalDate startInclusive, LocalDate endExclusive) {
        long startEpochDay = startInclusive.toEpochDay();
        long endEpochDay = endExclusive.toEpochDay();
        long randomDay = ThreadLocalRandom
                .current()
                .nextLong(startEpochDay, endEpochDay);

        return LocalDate.ofEpochDay(randomDay);
    }

    public static void writeToJson(List<Student> students){

        StringBuilder str = new StringBuilder();
        students.forEach(a-> str.append(a).append("\n"));

        writeToFile(str, "jsonOut.json");

    }

    public static void writeToJsonResult(List<Student> students, String filename){

        StringBuilder str = new StringBuilder();
        students.forEach(a-> str.append(a).append("\n"));

        writeToFile(str, filename);

    }

    private static void writeToCSVFile(List<Student> students){

        StringBuilder str = new StringBuilder();
        students.forEach(a-> str.append(a.toCSV()));

        writeToFile(str, "students.csv");
    }

    private static void writeToXMlFile(List<Student> students){

        StringBuilder str = new StringBuilder();
        students.forEach(a-> str.append(XML.toString(new JSONObject(a))));

        writeToFile(str, "students.xml");
    }


}
