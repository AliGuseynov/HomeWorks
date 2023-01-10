package az.code.leetCode;

import java.util.concurrent.Semaphore;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
//        Semaphore zero = new Semaphore(1);
//        Semaphore even = new Semaphore(0);
//        Semaphore odd = new Semaphore(0);
//

        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd();
        zeroEvenOdd.zero();
        zeroEvenOdd.even(5);
        zeroEvenOdd.odd(5);
    }
}
