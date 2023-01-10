package az.code.SingletonDesignPattern;

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton threadSafeSingleton;

    private ThreadSafeSingleton() {
    }

    //multithread
    public static synchronized ThreadSafeSingleton getInstance() {
        if (threadSafeSingleton == null) {
            threadSafeSingleton = new ThreadSafeSingleton();
        }
        return threadSafeSingleton;
    }

    public void test() {
        System.out.println("Thread Safe Singleton");
    }
}
