package az.code.SingletonDesignPattern;

public class EagerInitializedSingleton {
    private static final EagerInitializedSingleton singleObject = new EagerInitializedSingleton();

//instance yaradilmasin

    private EagerInitializedSingleton() {

    }


    public static EagerInitializedSingleton getInstance() {
        return singleObject;
    }

    public void test() {
        System.out.println("Eager Singleton");
    }
}
