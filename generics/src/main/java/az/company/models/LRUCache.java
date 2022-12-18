package az.company.models;

import java.util.*;


public class LRUCache {

    Set<Integer> cache;
    int capacity;

    public LRUCache(int capacity) {
        this.cache = new LinkedHashSet<Integer>(capacity);
        this.capacity = capacity;
    }

    // Əgər referans cachede yoxdursa, bu funksiya false qaytarır.
    // eger varsa referans davam edir
    // onu öndən çıxarır sona elave edir
    //ve geri true qaytarir
    public boolean get(int key) {
        if (!cache.contains(key))
            return false;
        cache.remove(key);
        cache.add(key);
        return true;
    }

    /*LRU cahce deki  x adresine referans edir*/
    public void refer(int key) {
        if (get(key) == false)
            put(key);
    }

    // cache elementlerini tərsine  göstərir
    public void getAll() {
        LinkedList<Integer> list = new LinkedList<>(cache);

        // DescendingIterator() metodu
        // java.util.LinkedList klassını geri qaytarmaq üçün istifadə olunur
        // bu LinkedList-dəki elementlər üzərində iterator
        // tərsinə ardıcıl sıralıyır
        Iterator<Integer> itr = list.descendingIterator();

        while (itr.hasNext())
            System.out.print(itr.next() + " ");
    }

    public void put(int key) {

        if (cache.size() == capacity) {
            int firstKey = cache.iterator().next();
            cache.remove(firstKey);
        }

        cache.add(key);
    }


}