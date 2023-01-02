package lesson4;

public class Main {
    public static void main(String[] args) {
        // int[] array = { 4, 17};
        int min = 4;
        int max = 17;
        int oddCount = 0;
        int evenCount = 0;
        // araliginda odd ve even saylarin hasilini tapin

        for (int i = 4; i < 17; i++) {
            if (i % 2 == 0) {
                evenCount++;
            } else oddCount++;
        }

        System.out.println("answer=");

    }
}
