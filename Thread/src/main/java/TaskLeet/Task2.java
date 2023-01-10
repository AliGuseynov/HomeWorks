package TaskLeet;

import java.util.function.IntConsumer;

public class Task2 {
    private int n;
    private int count;
    private int flag;
    private boolean lastPrintedEven;

    public Task2(int n) {
        this.n = n;
        this.count = 0;

        this.flag = 0;
        lastPrintedEven = true;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        int numOfZeroes = n;
        while(numOfZeroes-- > 0){
            while(flag != 0) {
                wait();
            }
            printNumber.accept(0);
            if(lastPrintedEven)
                flag = 1;
            else flag = 2;
            notifyAll();
        }

    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        int numOfEven = n/2;
        while(numOfEven-- > 0){
            while(flag != 2) {
                wait();
            }
            printNumber.accept(++count);
            lastPrintedEven = true;
            flag = 0;
            notifyAll();
        }
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        int numOfOdd = n - n/2;
        while(numOfOdd-- > 0){
            while(flag != 1) {
                wait();
            }
            printNumber.accept(++count);
            lastPrintedEven = false;
            flag = 0;
            notifyAll();
        }
    }

}
