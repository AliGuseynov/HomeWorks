package homeworks.homework5.task1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        Pattern p = Pattern.compile("[a-zA-Z]");
        Pattern p2 = Pattern.compile("[0-9]");

        Matcher m = p.matcher(text);
        Matcher m2 = p2.matcher(text);

        System.out.println("Reqem: ");
        while (m2.find()) {
            System.out.println(m2.group());
        }
        System.out.println("\n"+"Herfler: ");
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
