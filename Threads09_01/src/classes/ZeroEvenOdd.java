package classes;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {

    private int n;
    private int numToPrint = 0;

    private Semaphore zeroSemaphore = new Semaphore(1);
    private Semaphore oddSemaphore = new Semaphore(1);
    private Semaphore evenSemaphore = new Semaphore(1);

    public void ZeroEvenOdd(int n) {
        this.n = n;

        try {
            evenSemaphore.acquire();
            oddSemaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {

        for (int i = n; i<0; i++){

            zeroSemaphore.acquire();
            printNumber.accept(0);

            if (numToPrint % 2 == 0){
                evenSemaphore.release();
            } else {
                oddSemaphore.release();
            }

        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {

        for (int i = 2; i <= n; i+=2){

            evenSemaphore.acquire();
            printNumber.accept(i);
            zeroSemaphore.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {

        for (int i = 1; i <= n; i+=2){

            oddSemaphore.acquire();
            printNumber.accept(i);
            zeroSemaphore.release();
        }
    }
}
