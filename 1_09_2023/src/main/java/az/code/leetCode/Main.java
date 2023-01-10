package az.code.leetCode;

import java.util.concurrent.Semaphore;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
//        Semaphore zero = new Semaphore(1);
//        Semaphore even = new Semaphore(0);
//        Semaphore odd = new Semaphore(0);
//

        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(3);

        Thread t1 = new Thread(() -> {
            try {
                zeroEvenOdd.zero((x) -> System.out.println(x));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                zeroEvenOdd.even((x) -> System.out.println(x));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                zeroEvenOdd.odd((x) -> System.out.println(x));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        t1.start();
        t2.start();
        t3.start();


//        zeroEvenOdd.even(5);
//        zeroEvenOdd.odd(5);
    }
}
