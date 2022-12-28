import exceptions.CheckedExceptionHW;
import exceptions.UncheckedExceptionHW;

public class MyMath {


    public static int divide(int a, int b){
        if (b == 0){
            throw new UncheckedExceptionHW("You can't divide by zero", 1);
        } else {
            return a/b;
        }
    }

    public static int divideCountable(int a, int b) throws CheckedExceptionHW {
        if (a%2!=0 || b%2!=0){
            throw new CheckedExceptionHW();
        } else {
            return a/b;
        }
    }
}
