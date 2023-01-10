package az.code.leetCode;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int number;
    Semaphore zero = new Semaphore(1);
    Semaphore even = new Semaphore(0);
    Semaphore odd = new Semaphore(0);

//    public ZeroEvenOdd(int number) {
//        this.number = number;
//    }

    public ZeroEvenOdd() {
    }

    public void zero(IntConsumer num) throws InterruptedException {
        for (int i = 0; i <= number; i++) {
            zero.acquire();
            num.accept(0);
            if (i % 2 == 0) {
                even.release();
            } else {
                odd.release();
            }
        }

    }

    public void even(IntConsumer num) throws InterruptedException {
        for (int i = 2; i <= number; i++) {
            even.acquire();
            num.accept(i);
            zero.release();
        }

    }

    public void odd(IntConsumer num) throws InterruptedException {
        for (int i = 1; i < number; i++) {
            odd.acquire();
            num.accept(i);
            zero.release();
        }
    }
}
