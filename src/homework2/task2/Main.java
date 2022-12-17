package homework2.task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int temp = num;
        int divider = 1;
        while (temp > 10) {
            divider *= 10;
            temp /= 10;
        }
        switch (divider) {
            case 1000:
                System.out.println("minlik");
                break;
            case 100:
                System.out.println("yuzluk");
                break;
            case 10:
                System.out.println("onluq");
                break;
            case 1:
                System.out.println("teklik");
                break;
            default:
                System.out.println("--");
        }

//        System.out.println("temp=" + divider);
    }
}
