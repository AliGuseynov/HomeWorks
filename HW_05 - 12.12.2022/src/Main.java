import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {


        String input = "Hello 555, LOL +++- 9658 KEK4562?pr!klo??pr!pr!pr";
        //Task1(input);
        //Task2(input);
        //Task4(input);
        //Fizzbuzz.Task2(15);

//        System.out.println(MyMath.add("256", "159624783"));;


        System.out.println(MyMath.multiply("256545", "256"));

//        String test = "0000002200560000";
//
//        System.out.println(test.replaceAll("^[0]*", ""));
    }

    public static void Task1(String text) {

        System.out.println("Numbers: \n");

        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        System.out.println("Letters: \n");

        pattern = Pattern.compile("[a-zA-Z]");
        matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static void Task2(String text) {

        text = text.replaceAll("[0-9]", "");
        System.out.println(text);
    }

//    4. Method text qəbul edir. Əvvəlcə
//    həmin texti boşluqlar, vergül, nöqtə, nida, sual işarələrinə görə split edib
//    daha sonra təkrar sözləri çıxarmaqla vergüllə birləşdirib yeni text yaradıb
//    return etsin. (edited)
    public static String Task4(String text) {
        String[] str = text.split("[ ,.!?]+");
        String newText = "";

        for (String element : str) {
            System.out.println(element);
        }

        for (int i = 0; i < str.length; i++) {
            for (int j = i + 1; j < str.length; j++) {
                if (str[i].equals(str[j]))
                    newText += str[i] + ", ";
            }
        }
        return newText;
    }

}