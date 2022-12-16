import java.util.HashMap;

public class Fizzbuzz {
    public static void Task2(int number) {

        //// input daxil edilir: 3 e bolunurse fizz, 5 e bolunure buzz, ikisine de bolunurse fizz buzz output versin
        String text = "";
        //3 6 9 12 15
        // 5 10 15 20
        // 15
        HashMap<Integer, String> rules = new HashMap<Integer, String>();

        rules.put(3, "fizz");
        rules.put(5, "buzz");
        rules.put(15, "LALA");
        rules.put(4, "ALI");

        for (Integer key: rules.keySet()) {
            if(number % key == 0)
                text += rules.get(key);
        }

        System.out.print(text);
    }
}
