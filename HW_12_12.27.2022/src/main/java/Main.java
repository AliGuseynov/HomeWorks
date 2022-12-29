import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Random;

public class Main {

    private static Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {

//        Task3();
//        Task4();
        Task5();
    }

    //3. try with resourse ile file-i oxuyub setir ve setir chapa verin
    public static void Task3() {

        File file = new File("input.txt");
//        File file = new File("C:\\Users\\Murad\\Desktop\\Code Academy\\java-lessons\\Practice\\HW_11_12.27.2022\\Files\\input.txt");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            String line = bufferedReader.readLine();

            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    //4. 0-a bolme olarsa handle edin
    public static void Task4() {
        int a = 5;
        int b = 0;

        try {

            System.out.println(a / b);

        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

// 5. 1 try ichinde bir neche ferqli checked exception atan methodlari chagirin(custom ve IO ) ve ardicilliq ile catch edin
//    logger qoshub, hem file-a hem de console-a log edin
    public static void Task5() {
        Random random = new Random();

        int a = random.nextInt(10);
        int b = random.nextInt(2);

        try {

            double result = a / b;

            if (result % 3 == 0)
                throw new CustomCheckedException("Divisible by 3", 3);

            System.out.println(a + " / " + b + " = " + result);

        } catch (ArithmeticException | CustomCheckedException  e) {
            logger.warn(e.getMessage());
        }
    }
}