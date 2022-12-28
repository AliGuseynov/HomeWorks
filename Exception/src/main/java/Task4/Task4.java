package Task4;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            try {
                division(a, b);
            } catch (ArithmeticException ex) {
                System.out.println("Please enter the appropriate digits");
            }
        }
    }

    public static void division(int a, int b) {
        int c = a / b;
        System.out.println(c);
    }
}
