import inter.Cache;

import java.time.LocalDateTime;
import java.util.HashMap;

public class LRUCache <V, T> implements Cache<V,T>{
        private int capacity;
        private HashMap<V, Node<T>> cache;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            cache = new HashMap<V, Node<T>>(capacity);
        }
        @Override
        public T get(V key) {
            Node<T> node = cache.get(key);
            if(node != null){
                node.setTime(LocalDateTime.now());
            }
            return node != null ? node.getValue() : null;
        }

        @Override
        public void put(V key, T val) {
            if (get(key) == null && cache.size() == capacity) {
                removeOld();
            }
            cache.put(key, new Node( val, LocalDateTime.now()));
        }
        @Override
        public void removeOld(){
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

        @Override
        public void printAllValues() {
            for(Node<T> node: cache.values()){
                System.out.println(node);
            }
        }


    }

