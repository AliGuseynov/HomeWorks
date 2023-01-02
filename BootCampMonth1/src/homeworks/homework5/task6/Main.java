package homeworks.homework5.task6;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String output = "";

        HashMap<Integer, String> numbers = new HashMap<>();

        numbers.put(3, "Fizz");
        numbers.put(5, "Buzz");
        numbers.put(4, "Muzz");

        for (Integer key : numbers.keySet()) {
            if (num % key == 0) {
                output += numbers.get(key);
            }
        }

        System.out.println(output);
    }
}
