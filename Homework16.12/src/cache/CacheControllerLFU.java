package cache;

import linkedList.LinkedListNode;
import linkedList.MyLinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CacheControllerLFU <T>{


    MyLinkedList linkedList = new MyLinkedList();

    HashMap<T , LinkedListNode> listHashmap = new HashMap<>();

    HashMap<T, Integer> listUsed = new HashMap<>();

    int cacheSize;

    public CacheControllerLFU(int cacheSize) {
        this.cacheSize = cacheSize;
    }



    public void addItem(T item){
        if (listHashmap.containsKey(item)){

            sortUsage(listHashmap.get(item));

        } else {
            if (linkedList.getSize() >= cacheSize){  // it's okay

                LinkedListNode removedNode = linkedList.removeFirst();
                listHashmap.remove(removedNode.getItem());
                listUsed.remove(removedNode.getItem());
            }

            listHashmap.put(item, linkedList.addItemToCache(item));
            listUsed.put(item, 0);
        }}

    public T getElement(int index){

        T itemOut = (T)linkedList.getElementAtIndex(index);

        LinkedListNode nodeTemp = linkedList.getNodeAtIndex(index);
        sortUsage(nodeTemp);
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

    private void sortUsage(LinkedListNode node){
        boolean check = true;
        boolean direction = true;

        int count = listUsed.get(node.getItem())+1;
//        listUsed.remove(node.getItem());
        listUsed.put((T)node.getItem(), count);

        while (check){

            if (node.getPrevItem()!= null && listUsed.get(node.getPrevItem().getItem()) < listUsed.get(node.getItem())){
                direction = true;
            }
            if (node.getNextItem()!= null && listUsed.get(node.getNextItem().getItem()) > listUsed.get(node.getItem())){
                direction = false;
            } else {
                check = false;
            }
            linkedList.moveNode(direction, node);
        }


    }



}
