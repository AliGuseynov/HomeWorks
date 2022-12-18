package org.example;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
            System.out.print("yyyy-MM-dd seklinde daxil edin");
            String scDate = scanner.nextLine();
            LocalDate date = LocalDate.parse(scDate);
                int limit = LocalDate.now().getYear() - LocalDate.parse(scDate).getYear() +1;
                for (int i = 0; i < limit; i++) {
                    System.out.println(date.plusYears(i) + " " +
                    date.plusYears(i).getDayOfWeek());
                }
    }
}