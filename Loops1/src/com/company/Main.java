package com.company;

public class Main {

    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            int a = i;
            int sum = 0;

            while (a > 0) {

                sum += a % 10;
                a /= 10;
            }

            if (i % 10 != 3 && sum % 3 == 0) {
                System.out.println(i);
            }

        }
    }
}
