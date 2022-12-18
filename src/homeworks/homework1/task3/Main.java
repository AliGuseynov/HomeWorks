package homeworks.homework1.task3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int asimanAge = scanner.nextInt();
        int hasanAge = scanner.nextInt();
        int shamsAge = scanner.nextInt();
        int min = 0;
        int mid = 0;
        int max = 0;

        if (asimanAge > hasanAge && asimanAge > shamsAge) {
            max = asimanAge;
            System.out.println("max age=" + max);
        } else if (asimanAge < hasanAge && asimanAge < shamsAge) {
            min = asimanAge;
            System.out.println("min age=" + min);
        }


        if (hasanAge > asimanAge && hasanAge > shamsAge) {
            max = hasanAge;
            System.out.println("max age=" + max);
        } else if (hasanAge < asimanAge && hasanAge < shamsAge) {
            min = hasanAge;
            System.out.println("min age=" + min);
        }


        if (shamsAge > asimanAge && shamsAge > hasanAge) {
            max = shamsAge;
            System.out.println("max age=" + max);
        } else if (shamsAge < asimanAge && shamsAge < hasanAge) {
            min = shamsAge;
            System.out.println("min age=" + min);
        }


        if (max == asimanAge && min == shamsAge) {
            System.out.println("mid age=" + hasanAge);
        } else if (max == hasanAge && min == asimanAge) {
            System.out.println("mid age=" + shamsAge);

        } else System.out.println("mid age=" + asimanAge);
    }
}
