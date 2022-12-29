package task4;

import java.util.Scanner;

public class Task4 {
    public static void task4(){
        Scanner sc=new Scanner(System.in);
        double a=sc.nextDouble();
        double b=sc.nextDouble();

        try{
            division(a,b);
        }catch (ArithmeticException e){
            System.out.println("enter correct number ");
            task4();
        }
    }
    public static void division(double a, double b) {
        double c = a / b;
        System.out.println(c);
    }
}
