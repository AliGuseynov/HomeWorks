package az.code.leetcode;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int num;
    private int lastPrinted;

    private Semaphore oddSemp, evenSemp, zeroSemp;
    public ZeroEvenOdd(int n) {
        this.num = n;
        this.lastPrinted=0;
        this.zeroSemp =new Semaphore(1);
        this.oddSemp =new Semaphore(1);
        this.evenSemp =new Semaphore(1);

        try{
            this.evenSemp.acquire();
            this.oddSemp.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        int numZero = num;
        while(numZero --> 0){
            zeroSemp.acquire();
            printNumber.accept(0);

            if(lastPrinted % 2 == 0 ){
                oddSemp.release();
            }else {
                evenSemp.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        int numEven = num /2;
        while (numEven --> 0){
            evenSemp.acquire();
            printNumber.accept(++lastPrinted);
            zeroSemp.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        int numOdd = num - num /2 ;
        while (numOdd --> 0){
            oddSemp.acquire();
            printNumber.accept(++lastPrinted);
            zeroSemp.release();
        }
    }
}
