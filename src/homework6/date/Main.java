package homework6.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws ParseException {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
//        String date = "26/08/2001";
//        LocalDate localDate = LocalDate.parse(date, formatter);
//        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
//
//        System.out.println("day:" + dayOfWeek.toString());


        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter date in yyyy-MM-dd format:");
            String input = scanner.nextLine();
            LocalDate testDate = LocalDate.parse(input);
            if (testDate.isBefore(LocalDate.now().minusDays(365))) {
                int counter = LocalDate.now().getYear() - LocalDate.parse(input).getYear();
                for (int i = 0; i < counter; i++) {
                    System.out.println(testDate.plusYears((long) i) + " " + testDate.plusYears((long) i).getDayOfWeek());
                }
            }
        }


    }
}
