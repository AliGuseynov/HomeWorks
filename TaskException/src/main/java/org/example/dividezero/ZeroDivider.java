package org.example.dividezero;

import org.example.exceptions.CheckedException;

public class ZeroDivider {
    public static void main(String[] args) {
        try {
            System.out.println(divide(12,0));
        } catch (ArithmeticException arithmeticException){
           arithmeticException.printStackTrace();
        }
    }

    public static int divide(int a,int b){
        return a/b;
    }
}
