package homework5.task5;

import java.math.BigInteger;

public class MyMath {

    public static String add(String str1, String str2) {
        if (str1.length() > str2.length()) {
            String t = str1;
            str1 = str2;
            str2 = t;
        }
        String str = "";

        int n1 = str1.length(), n2 = str2.length();

        str1 = new StringBuilder(str1).reverse().toString();
        str2 = new StringBuilder(str2).reverse().toString();

        int carry = 0;
        for (int i = 0; i < n1; i++) {
            int sum = ((int) (str1.charAt(i) - '0') +
                    (int) (str2.charAt(i) - '0') + carry);
            str += (char) (sum % 10 + '0');

            carry = sum / 10;
        }

        for (int i = n1; i < n2; i++) {
            int sum = ((int) (str2.charAt(i) - '0') + carry);
            str += (char) (sum % 10 + '0');
            carry = sum / 10;
        }

        if (carry > 0)
            str += (char) (carry + '0');

        str = new StringBuilder(str).reverse().toString();
        return str;
    }

    public static void main(String[] args) {

        String str1 = "12";
        String str2 = "198111";
        System.out.println(add(str1, str2));
    }
}
