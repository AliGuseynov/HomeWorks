package az.code.SingletonDesignPattern;

public class LazyInitializedSingleton {
    private static LazyInitializedSingleton lazyInitializedSingleton;

    private LazyInitializedSingleton() {
    }

    //obyekte erishim varsa
    public static LazyInitializedSingleton getInstance() {
        if (lazyInitializedSingleton == null) {
            lazyInitializedSingleton = new LazyInitializedSingleton();
        }
        return lazyInitializedSingleton;
    }

    public void test() {
        System.out.println("Lazy Singleton");
    }
}
