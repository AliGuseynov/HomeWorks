package homeworks.homework16.task1;

import java.time.LocalDateTime;
import java.util.HashMap;

public class LRUCache<V, T> {
    private int capacity;
    private HashMap<V, Node<T>> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<V, Node<T>>(capacity);
    }

    public T get(V key) {
        Node<T> node = cache.get(key);
        if(node != null){
            node.setTime(LocalDateTime.now());
        }
        return node != null ? node.getValue() : null;
    }

    public void put(V key, T value) {
        if (get(key) == null && cache.size() == capacity) {
            removeOld();
        }
        cache.put(key, new Node(value, LocalDateTime.now()));

    }

    private void removeOld(){
        LocalDateTime date = null;
        V deletedRecord = null;
        for (V item : cache.keySet()) {
            Node<T> node = cache.get(item);
            if(deletedRecord == null || node.getTime().isBefore(date)){
                date = node.getTime();
                deletedRecord = item;
            }
        }
        cache.remove(deletedRecord);
    }
    public void printAllKeys(){
        for(V key: cache.keySet()){
            System.out.println(key);
        }
    }
}

