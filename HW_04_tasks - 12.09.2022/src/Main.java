import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // Task 01

        int[] array = {3, 5};

        int oddSum = 0;
        int evenSum = 0;

        for(int element = array[0]; element <= array[1]; element++) {

            if(element % 2 == 0) {
                evenSum += element;
            } else {
                oddSum += element;
            }
        }

        System.out.println(evenSum + " " + oddSum);
        System.out.println("Sum " + evenSum + oddSum);
        System.out.println(evenSum * oddSum);

        // Task 02
        //123 -> 321

        int number = 50;

        while (number > 0) {
            int digit = number % 10;
            number /= 10;
            System.out.print(digit);
        }

        System.out.println();
        // Task 3
//        Metod yazin ki daxil sozde axtarilan elementin nece defe oldugunu tapsin
//        mes: text - matata ; axtarilan herf - t = tekrarlanma 2 defe

        String text = "matata";
        // count of each letter
        Map<Character, Integer> letters = new HashMap<Character, Integer>();

        for (char letter: text.toCharArray()) {

            if(letters.containsKey(letter)) {
                letters.put(letter, letters.get(letter) + 1);
            } else {
                letters.put(letter, 1);
            }
        }

        char input = 't';
        System.out.println(input + " " + letters.get(input));
    }
}