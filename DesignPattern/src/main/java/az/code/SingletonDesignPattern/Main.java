package az.code.SingletonDesignPattern;

public class Main {
    public static void main(String[] args) {

        EagerInitializedSingleton.getInstance().test();//thread problemi
        StaticBlockSingleton.getInstance().test();//thread problemi
        LazyInitializedSingleton.getInstance().test();//thread safe deyil
        ThreadSafeSingleton.getInstance().test();// vaxt aparir performansa tesir edr
        
    }
}
