import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import java.util.Map.Entry;

public class LRUCache <T> {

    int size;
    HashMap<T, LocalDateTime> cache;


    public LRUCache(int max) {
        this.size = max;
        this.cache = new HashMap<>(max);
    }

    public void addElement(T item) {
        LocalDateTime dateTime = LocalDateTime.now();

        if (size > cache.size())
            cache.put(item, dateTime);
        else {

            List<LocalDateTime> times = new ArrayList<>(cache.values());

            LocalDateTime time = LocalDateTime.now();

            for (LocalDateTime e : times)
                if (time.isAfter(e))
                    time = e;

            System.out.println("TIME " + time);

            cache.values().remove(time);

            cache.put(item, dateTime);
        }
    }

    public T getElement(int index) {
        List<T> keys = new ArrayList<>(cache.keySet());

        if (keys.size()-1 >= index)
            return keys.get(index);
        else
            return null;
    }

    public List<T> printAll() {

        return new ArrayList<>(cache.keySet());
    }

    public HashMap<T, LocalDateTime> printAllDetails() {

        return cache;
    }
}
