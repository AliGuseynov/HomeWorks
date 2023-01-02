package homework2.task4;

public class Main {
    public static void main(String[] args) {
        int num = 123321;
        int a=num;
        int qaliq = 0;
        int newNumber = 0;
        while (num > 0) {
            qaliq = num % 10;
            num /= 10;
            newNumber = newNumber * 10 + qaliq;
        }
        if (newNumber == a) {
            System.out.println("Palindrom");
        } else System.out.println("not Palindrom");
    }
}
