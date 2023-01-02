package homeworks.homework2.task3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int qal = 0;
        int sum = 0;
        while (num > 0) {
            qal = num % 10;
            num /= 10;

            if (qal == 2 || qal == 3 || qal == 5 || qal == 7) {
                sum = sum + qal;
            }

        }
        System.out.println("sum=" + sum);

    }
}
