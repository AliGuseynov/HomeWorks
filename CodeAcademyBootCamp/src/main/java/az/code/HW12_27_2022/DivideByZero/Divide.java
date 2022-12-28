package az.code.HW12_27_2022.DivideByZero;

import java.util.Scanner;

public class Divide {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter two number:");
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        int answer = 0;

        try {
            answer = number1 / number2;
        } catch (ArithmeticException arithmeticException) {
            arithmeticException.printStackTrace();
        }


    }
}
