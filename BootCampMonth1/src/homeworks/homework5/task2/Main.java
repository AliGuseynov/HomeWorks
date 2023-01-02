package homeworks.homework5.task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String newText = "";

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                newText += str.charAt(i);
            }
        }
        System.out.print("new text:" + newText);
    }


}

