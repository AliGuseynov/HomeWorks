package cache;

import java.time.LocalDateTime;
import java.util.HashMap;

public class LFUCache<V,T> implements Cache<V,T>{

    private int capacity;
    private HashMap<V, Node<T>> cache;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
    }

    @Override
    public T get(V key) {
        Node<T> node = cache.get(key);
        if(node != null){
            node.setCount(node.getCount()+1);
        }
        return node != null ? node.getValue() : null;
    }
    @Override
    public void put(V key, T value) {
        if (get(key) == null && cache.size() == capacity) {
            remove();
        }
        cache.put(key, new Node(value, LocalDateTime.now()));

    }


    @Override
    public void remove(){
        int usage = 3;
        V deletedRecord = null;
        for (V item : cache.keySet()) {
            Node<T> node = cache.get(item);
            if(deletedRecord == null || node.getCount()<usage){
                usage = node.getCount();
                deletedRecord = item;
            }
        }
        cache.remove(deletedRecord);
    }
    @Override
    public void printAllKeys(){
        for(V key: cache.keySet()){
            System.out.println(key);
        }
    }
}
