import homework15_12.Homework15_12Runner;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

       /*
       ============Task 2================================
        Homework15_12Runner runner = new Homework15_12Runner();
        runner.run(); // run homework by date. Just to simplify
*/




        //==========Task 3===============================

        finDayOfWeekOfBirthdays();




    }

    public static void finDayOfWeekOfBirthdays(){
        Pattern pattern = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}");

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("Enter date in yyyy-MM-dd format:");
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            boolean matchFound = matcher.find();
            if(matchFound) {
                LocalDate testDate = LocalDate.parse(input);
                if (testDate.isBefore(LocalDate.now())){
                    int counter = LocalDate.now().getYear() - LocalDate.parse(input).getYear();
                    for (int i = 0; i<counter; i++){
                        System.out.println(testDate.plusYears((long)i)+" " + testDate.plusYears((long)i).getDayOfWeek());
                    }
                }
            } else {
                System.out.print("Düzgün tarix daxil edin ");
            }


        }
    }
}