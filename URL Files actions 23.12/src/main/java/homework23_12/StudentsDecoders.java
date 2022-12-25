package homework23_12;

import homework23_12.Classes.Student;

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.stream.Collectors;


public class StudentsDecoders {

    private static int exportCounter = Integer.parseInt(loadProperties("exportCounter"));

    public static void run(){


        List<Student> students = FileReader.readStudentFile("C:\\Users\\PC\\IdeaProjects\\shared\\URL Files actions 23.12\\files\\StudentsTask\\students.csv");
        students.forEach(a-> a.printStudent());

        int stage1 = startUI();

        switch (stage1){
            case 1:
                int sortoption = sortOptions();
                sort(sortoption, students);
                break;
            case 2:
                compare(students);
                break;
            case 3:
                search(students);
                break;
        }

    }


    private static int startUI(){

        System.out.println("Choose option: \n" +
                "1- Sort\n" +
                "2- Compare\n" +
                "3- Search\n");

        return checkInput(3);
    }

    private static int sortOptions(){
        System.out.println("Sort by: \n" +
            "1- ID\n" +
            "2- Name\n" +
            "3- Surname\n" +
            "4- Birthdate\n");

        return checkInput(4);
    }

    private static void sort(int option, List<Student> students){

        switch (option){
            case 1:
                students.sort(Comparator.comparing(Student::getId));
                updateProperty("exportCounter", String.valueOf(exportCounter++));
                Seeder.writeToJsonResult(students, "SortById" + exportCounter + ".json");
                students.forEach(System.out::println);
                startUI();
                break;
            case 2:
                students.sort(Comparator.comparing(Student::getName));
                updateProperty("exportCounter", String.valueOf(exportCounter++));
                Seeder.writeToJsonResult(students, "SortByName" + exportCounter + ".json");
                students.forEach(System.out::println);
                startUI();
                break;
            case 3:
                students.sort(Comparator.comparing(Student::getSurname));
                updateProperty("exportCounter", String.valueOf(exportCounter++));
                Seeder.writeToJsonResult(students, "SortBySurname" + exportCounter + ".json");
                students.forEach(System.out::println);
                startUI();
                break;
            case 4:
                students.sort(Comparator.comparing(Student::getBirthdate));
                updateProperty("exportCounter", String.valueOf(exportCounter++));
                Seeder.writeToJsonResult(students, "SortByBirthdate" + exportCounter + ".json");
                students.forEach(System.out::println);
                startUI();
                break;

        }

        startUI();
    }


    private static int checkInput(int maxValue){
        Scanner scanner = new Scanner(System.in);
 boolean whileBreaker = true;
 int intout = 0;
        while (whileBreaker){
            intout = Integer.parseInt(scanner.nextLine());
            if (intout>0 && intout <= maxValue){
                whileBreaker = false;
            }
        }
        return intout;

    }

    public static String loadProperties(String property){
        try (InputStream input = new FileInputStream("files\\system\\config.test")) {
            Properties prop = new Properties();
            prop.load(input);

            return prop.getProperty(property);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private static void updateProperty(String property, String value){
        File file = new File("files\\system\\config.test");

        try {

            InputStream input = new FileInputStream("files\\system\\config.test");
            FileReader reader = new FileReader();
            FileWriter writer = new FileWriter(file);

            Properties p = new Properties();
            p.load(input);
            reader.toString();

            p.setProperty(property,value);
            p.store(writer,"write a file");
            System.out.println("Properties updated");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Writing error");
        }


    }

    private static void compare(List<Student> students){
        System.out.println("Enter id 1: ");
        Scanner scanner = new Scanner(System.in);
        int id1 = scanner.nextInt();
        System.out.println("Enter id 2: ");
        int id2 = scanner.nextInt();

        Student student1 = null;
        Student student2 = null;

        for (int i = 0; i< students.size(); i++){
            if (students.get(i).getId() == id1){
                student1 = students.get(i);
            } else if(students.get(i).getId() == id2){
                student2 = students.get(i);
            }
        }
        if (student1.getBirthdate().isBefore(student2.getBirthdate())){
            System.out.println(student1);
        } else {
            System.out.println(student2);
        }

        run();
    }

    private static void search(List<Student> students){
        System.out.println("Enter search: ");
        Scanner scanner = new Scanner(System.in);
        String search = scanner.nextLine();

        for (int i = 0; i< students.size(); i++){
            if (students.get(i).toString().contains(search)){
                System.out.println(students.get(i));
            }
        }

        run();
    }

}
