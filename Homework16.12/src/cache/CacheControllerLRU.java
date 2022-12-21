package cache;

import linkedList.LinkedListNode;
import linkedList.MyLinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CacheControllerLRU<T>{
    MyLinkedList linkedList = new MyLinkedList();

    HashMap<T , LinkedListNode> listHashmap = new HashMap<>();

    int cacheSize;

    public CacheControllerLRU(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public void addItem(T item){
        if (listHashmap.containsKey(item)){
            linkedList.getNodeToEnd(listHashmap.get(item));
        } else {
        if (linkedList.getSize() < cacheSize){  // it's okay

            listHashmap.put(item, linkedList.addItemToCache(item));
        } else {
            LinkedListNode removedNode = linkedList.removeFirst();

            listHashmap.remove(removedNode.getItem());

            listHashmap.put(item, linkedList.addItemToCache(item));
        }

    }}

    public T getElement(int index){

        T itemOut = (T)linkedList.getElementAtIndex(index);
        linkedList.getNodeToEnd(listHashmap.get(itemOut));
        return itemOut;
    }

    public List<T> printAll(){
        List<T> allList = new ArrayList<>();

        allList = linkedList.getAll();

        for (T item: allList){
            System.out.println(item);
        }
        return allList;
    }


}
