package homework2.task6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int temp1 = number;
        int temp2 = number;
        int qal1 = 0;
        int qal2 = 0;
        int count = 0;
        int answer = 0;
        while (temp1 > 0) {
            qal1 = temp1 % 10;


            while (temp2 > 0) {
                qal2 = temp2 % 10;
                if (qal1 == qal2) {
                    answer = qal1;
                    count++;
                }
                temp2 = temp2 / 10;
            }


            temp1 = temp1 / 10;
        }
        if (count == 1) {
            System.out.println("tekrarlanan eded yoxdur");
        } else {
            System.out.println(qal1 + " tekrarlanir");
        }
    }
}
