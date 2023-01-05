package com.company;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Day: ");
        String day = scan.nextLine();
        day.replace(" ", "");

        System.out.println("Month: ");
        String month = scan.nextLine();
        month.replace(" ", "");

        System.out.println("Year: ");
        int year = scan.nextInt();

        findDayOfWeek(day, month, year);
    }

    public static void findDayOfWeek(String day, String month, int year) throws ParseException {
        System.out.println("\nYour birthday will be on: \n");

        for(int i = 0; i < 70 ; i++) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String birthday = day + "/" + month + "/" + String.valueOf(year+i);
            Date date = format.parse(birthday);
            DateFormat format1 = new SimpleDateFormat("EEEE , yyyy");
            String dayOfWeek = format1.format(date);
            System.out.println(dayOfWeek);
        }
    }
}
