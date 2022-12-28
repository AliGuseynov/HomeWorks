import exceptions.CheckedExceptionHW;
import exceptions.GenericCheckedException;
import exceptions.UncheckedExceptionHW;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {



//        task2();

//        Task3.run();

//        task4(); // used unchecked exception from Task 1

//        task5();
        
    }



    private static void task4(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {



                System.out.println("\nWelcome to division program");

                System.out.print("Enter dividend: ");
                int num1 = scanner.nextInt();

                System.out.print("Enter divisor: ");
                int num2 = scanner.nextInt();

                System.out.println("Result: " + MyMath.divide(num1, num2));

            } catch (UncheckedExceptionHW e) {
                logger.warn("Division program error", e);
            }
        }
    }


    private static void task2(){

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {


                System.out.println("\nWelcome to countable division program");

                System.out.print("Enter dividend: ");
                int num1 = scanner.nextInt();

                System.out.print("Enter divisor: ");
                int num2 = scanner.nextInt();

                System.out.println("Result: " + MyMath.divideCountable(num1, num2));


            } catch (CheckedExceptionHW e) {
                logger.warn("Countable division error", e);
            }
        }
    }

    private static void task5(){
        FileReader fileReader = null;
        try {

//            String fileLocation = "files\\numbers.txt";
            String fileLocation = "";
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileLocation));
            String line = bufferedReader.readLine();

            while (line != null) {
                line = bufferedReader.readLine();
                    readNumbers(line);
            }


        } catch (IOException | GenericCheckedException e) {
            logger.warn("Task 5 error", e);
        }
    }

    private static void readNumbers(String text) throws GenericCheckedException {

            String regex = "[0-9]+";

            Pattern p = Pattern.compile(regex);

            boolean exceptionFound = true;

            if (text == null) {
                throw new GenericCheckedException("Line is null");
            }
            Matcher m = p.matcher(text);


        if (m.matches()){
            System.out.println(text);
        } else {
            throw new GenericCheckedException("String " + text + " contains text!");
        }
    }
}
