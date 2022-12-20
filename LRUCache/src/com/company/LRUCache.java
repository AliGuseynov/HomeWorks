package com.company;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class LRUCache <T> {
    private Deque<T> deque;
    private HashSet<T> hashSet;
    private final int CHACHE_SIZE;

    public LRUCache(){
        deque = new LinkedList<>();
        hashSet = new HashSet<>();
        CHACHE_SIZE = 3;
    }

    public void addElement(T item){
        if(!hashSet.contains(item)){
            if(deque.size() == CHACHE_SIZE){
                T lastItem = deque.removeLast();
                hashSet.remove(lastItem);
            }
        }
        else{
            deque.remove(item);
        }
        deque.push(item);
        hashSet.add(item);
    }
    public T getElement(int index) {
            List<T> list = (LinkedList) deque;
            return list.get(index);
    }

    public Deque<T> printAll(){
        return deque;
    }
}
