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

    public static String multiply(String a, String b) throws Exception {

//        int length = Math.max(a.length(), b.length());
//        String result = "";
//
//        if (a.length() > b.length()) {
//            b = "0".repeat(length - b.length()) + b;
//        } else {
//            a = "0".repeat(length - a.length()) + a;
//        }
//
//        int num = 0;
//        String num2 = "";
//        int dozen = 0;
//
//
//        int count = 1;
//
//        for (int i = length - 1; i >= 0; i--) {
//            System.out.println("I = "+ i + " " + Character.getNumericValue(b.charAt(i)));
//            for (int j = length - 1; j >= 0; j--) {
//                num = Character.getNumericValue(a.charAt(j)) * Character.getNumericValue(b.charAt(i)) + dozen;
//
//                dozen = num / 10;
//
//                result += num % 10;
//
//
//
//                System.out.println(i + " " + j + " " + num);
//            }
//
//
//
//            if (dozen != 0)
//                result += dozen;
//
//
//            if(num2.equals("")) {
//                num2 = MyMath.add(num2, result);
//                System.out.println("A1 " + num2);
//            }
//            else {
////
//                System.out.println("NUM2 " + num2);
//                System.out.println("A22 " + "0".repeat(count)  + result);
//                result = "0".repeat(count)  + result;
//                num2 = MyMath.add(reverse(num2), reverse(result));
//                System.out.println("A2 " + num2);
//
//            }
//
//
//            System.out.println(result + " " + num2 + " "  + reverse(num2));
//            System.out.println(reverse(result));
//
//            result = "";
//            dozen = 0;
//            count++;
//        }
//
//
//        System.out.println("REST " + num2);

        return null;
    }
}
