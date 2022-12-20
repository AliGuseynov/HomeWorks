import cache.LFUCache;
import cache.LRUCache;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        LFUCache<String, String> lruCache = new LFUCache<>(5);
        lruCache.put("Test1", "Test1");
        Thread.sleep(10);
        lruCache.put("Test2", "Test2");
        Thread.sleep(10);
        lruCache.put("Test3", "Test3");
        Thread.sleep(10);
        lruCache.put("Test4", "Test4");
        Thread.sleep(10);
        lruCache.put("Test5", "Test5");
        Thread.sleep(10);

        lruCache.put("Test1", "Test1");
        Thread.sleep(10);

        lruCache.get("Test2");
        Thread.sleep(10);
        lruCache.put("Test6", "Test6");
        Thread.sleep(10);
        lruCache.printAllKeys();


    }
}