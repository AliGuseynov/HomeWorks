package homeworks.homework1.task2;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        int newAmount = amount;
        BigDecimal kom = new BigDecimal("0");

        if (newAmount > 1000) {
            kom = BigDecimal.valueOf((newAmount - 1000) * 0.1);
            newAmount = 1000;
        }
        if (newAmount > 500) {
//            System.out.println("kom1=" + kom);
            kom = kom.add(BigDecimal.valueOf((newAmount - 500) * 0.07));
            newAmount = 500;

        }
        if (newAmount > 100) {
//            System.out.println("kom2=" + kom);
            kom = kom.add(BigDecimal.valueOf((newAmount - 100) * 0.05));

        }
        System.out.print("kom=" + kom);

    }
}
