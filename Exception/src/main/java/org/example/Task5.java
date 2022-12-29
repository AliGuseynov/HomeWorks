package org.example;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import task1.MyExceptionNullPointer;
import task1.Person;
import task4.Task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Period;
import java.util.Scanner;

public class Task5 {
    private static Logger logger = LogManager.getLogger(Task5.class);

    public static void task5() {
//        try {
////            Scanner sc = new Scanner(System.in);
////            double a = sc.nextDouble();
////            double b = sc.nextDouble();
////            Task4.division(a, b);
//
//        } catch (ArithmeticException ex) {
//            logger.warn("Error", ex);
//            task5();
//        }
        FileReader fileReader = null;
        try {

//            String fileLocation = "files\\numbers.txt";
            String fileLocation = "Error time";
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileLocation));
            String line = bufferedReader.readLine();

            while (line != null) {
                line = bufferedReader.readLine();
                System.out.println(line);
            }
            Person person=new Person();
            System.out.println(person.name);

        } catch (IOException  e) {
            logger.warn("Task 5 error", e);


        }
    }


}
