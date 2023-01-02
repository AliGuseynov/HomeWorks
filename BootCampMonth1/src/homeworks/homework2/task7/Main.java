package homeworks.homework2.task7;

public class Main {
    public static void main(String[] args) {

//        for (int i = 1000; i > 0; i--) {
//            if (i % 3 == 0 && i % 10 != 3) {
//                System.out.println("eded=" + i);
//            }
//
//        }

//        int c = 0;
//        int b = 0;
//        for (int i = 1000; i > 1; i--) {
//            int a = i;
//            if (i % 10 != 3) {
//                while (i > 0) {
//                    System.out.println("i" + i);
//                    c = i % 10;
//                    i /= 10;
//                    b = b + c;
//                }
//                System.out.println("b"+b);
//                if (b % 3 == 0) {
//                    System.out.println("i=" + b);
//                }
//            }
//
//        }

        for (int i = 1; i < 1000; i++) {
            int sum = 0;
            int temp = i;

            while (temp > 0) {
                sum = sum + temp % 10;
                temp /= 10;
            }
            if (i % 10 != 3 && sum % 3 == 0) {
                System.out.println(i);
            }
        }


    }
}
