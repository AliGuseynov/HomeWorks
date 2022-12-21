public class Main {
    public static void main(String[] args) {

        LRUCache cache = new LRUCache<>(3);


        cache.put(1, 1);
        cache.put(2, 0);


        System.out.println(cache.get(2));
    }
}