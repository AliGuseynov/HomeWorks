package az.code.SingletonDesignPattern;

public class StaticBlockSingleton {


    private static StaticBlockSingleton staticBlockSingleton;

    private StaticBlockSingleton() {
    }

    static {
        try {
            staticBlockSingleton = new StaticBlockSingleton();
        } catch (Exception e) {
        }
    }

    public static StaticBlockSingleton getInstance() {
        return staticBlockSingleton;
    }

    public void test() {
        System.out.println("Static Block Singleton");
    }
}
