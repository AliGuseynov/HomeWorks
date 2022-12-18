import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyMath {

    public static String add(String a, String b) throws Exception {

        Pattern pattern = Pattern.compile("[.,]");
        Matcher matcher = pattern.matcher(a + b);

        if (matcher.find())
            throw new Exception("wrong input");

        int length = Math.max(a.length(), b.length());
        String result = "";

        if (a.length() > b.length()) {
            b = "0".repeat(length - b.length()) + b;
        } else {
            a = "0".repeat(length - a.length()) + a;
        }

        int num;
        int dozen = 0;

        for (int i = length - 1; i >= 0; i--) {
            num = Character.getNumericValue(a.charAt(i)) + Character.getNumericValue(b.charAt(i)) + dozen;

            dozen = num / 10;

            result += num % 10;
        }

        return reverse(result);
    }

    public static String reverse(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            result = text.charAt(i) + result;
        }

        return result;
    }

    public static String multiply(String a, String b) {

        int result = 0;

        int dozen = 1;
        int count = 1;
        int sum = 0;


        for (int i = a.length() - 1; i >= 0; i--) {
            System.out.println("i = " + Character.getNumericValue(a.charAt(i)));

            for (int j = b.length() - 1; j >= 0; j--) {
                System.out.println("j = " + Character.getNumericValue(b.charAt(j)));

                sum += Character.getNumericValue(a.charAt(i)) * Character.getNumericValue(b.charAt(j)) * dozen;

                dozen *= 10;


                System.out.println(sum);
            }
            
            result += sum * count;

            sum = 0;
            dozen = 1;
            count *= 10;
        }



        return Integer.toString(result);
    }
}
