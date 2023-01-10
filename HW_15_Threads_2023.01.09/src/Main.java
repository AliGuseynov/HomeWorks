import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Callable callable = new MyCallable();

        System.out.println(callable.call());
    }
}