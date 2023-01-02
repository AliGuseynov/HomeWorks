package homework2.task1;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i < 1000; i++) {
            int sum = 0;
            int temp = i;

            while (temp > 0) {
                sum = sum + temp % 10;
                temp /= 10;
            }
            if (i % 5 == 0 && sum % 5 == 0) {
                System.out.println(i);
            }
        }
    }
}
