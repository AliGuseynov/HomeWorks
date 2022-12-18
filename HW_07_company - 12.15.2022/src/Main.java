import UI.UI;
import model.Employee;
import model.Operator;
import service.CompanyService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        UI ui = new UI();
//
//        ui.run();

        Task3();
    }

    public static void Task3() {
//        Doğum tarixini qəbul edib bütün ad günlərinin həftənin hansı günlərinə düşdüyünü çap etmək

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input date YYYY-MM-DD");

        String input = scanner.nextLine();
        LocalDate DOB = LocalDate.parse(input);

        for (LocalDate i = DOB; i.isBefore(LocalDate.now().plusDays(1)); i = i.plusYears(1)) {
            System.out.println(i.getYear() + " " + i.getDayOfWeek());
        }

//        for (int i = 1998; i <= LocalDate.now().getYear(); i++) {
//            System.out.println(i + " " + DOB.getDayOfWeek());
//            DOB = DOB.plusYears(1);
//        }

    }
}