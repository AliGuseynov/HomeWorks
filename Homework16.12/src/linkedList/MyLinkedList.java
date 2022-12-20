package linkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyLinkedList <T>{


    private LinkedListNode<T> item0;
    private LinkedListNode<T> itemN;

    private int size = 0;


    public void addItem (T item){
        if (item0 == null){
            item0 = new LinkedListNode<>(item);
            itemN = item0;
        } else {
            LinkedListNode<T> newItem = new LinkedListNode<>(item);
            newItem.setPrevItem(itemN);
            itemN.setNextItem(newItem);
            if (size == 1){
            item0.setNextItem(newItem);
            }
            itemN = newItem;
        }
        size++;
        System.out.println(itemN);
    }

    public T getElementAtIndex(int index){

        if (index>size){ return null;}
        else {

        LinkedListNode<T> tempItem = null;
        tempItem = item0;
        for (int i = 0; i<index;i++){

            if (i < index) {
                tempItem = tempItem.getNextItem();
            }
        }
        return tempItem.getItem();
    }}

    private LinkedListNode getNodeAtIndex(int index){
        if (index>size){ return null;}
        else {
        LinkedListNode<T> tempItem = null;
        tempItem = item0;
        for (int i = 0; i<index;i++){
            if (i < index){
                tempItem = tempItem.getNextItem();
            }
        }
        return tempItem;
    }}

    public LinkedListNode<T> removeIndex(int index){
        if (index<size || index>=0){
        LinkedListNode<T> element = getNodeAtIndex(index);

        if (element.getPrevItem() != null && element.getNextItem() != null){
            element.getPrevItem().setNextItem(element.getNextItem());
            element.getNextItem().setPrevItem(element.getPrevItem());
        } else if ((element.getPrevItem() != null &&  element.getNextItem() == null)
                || (element.getPrevItem() == null &&  element.getNextItem() != null)){

            if (element.getPrevItem() == null){
                element.getNextItem().setPrevItem(null);
                item0 = element.getNextItem();
            } else {
                element.getPrevItem().setNextItem(null);
                itemN = element.getPrevItem();

            }

        } else {
            size = 0;
            item0 = null;
            itemN = null;
        }

        size--;
        return element;}
        else {
            return null;
        }
    }

    public LinkedListNode<T> removeFirst(){
        LinkedListNode node = item0;
        removeIndex(0);
    return node;}
    public LinkedListNode<T> removeLast(){
        LinkedListNode node = itemN;
        removeIndex(size-1);
        return node;}

    public void printList(){
        boolean whileBreaker = true;
        LinkedListNode<T> item = item0;
        while (whileBreaker){
            System.out.println("Item " + item);
            if (item.getNextItem() != null){
            item = item.getNextItem();} else {whileBreaker = false;}
        }
    }

    public int findItem(T item){
        int indexOut = -1;

        LinkedListNode<T> tempItem = item0;
        for (int i = 0; i<size;i++){

            if (Objects.equals(tempItem.getItem(), item.toString())) {
                indexOut = i;
                break;
            } else {
                System.out.println(item.getClass() + " " + tempItem.getItem().getClass());
                tempItem = tempItem.getNextItem();
            }
        }
        return indexOut;
    }

    public T removeNode(LinkedListNode<T> node){
        if (node == item0 && node.getNextItem() != null){
            item0 = node.getNextItem();
        } else if (node == itemN && node.getPrevItem() != null){
            itemN = node.getPrevItem();
        } else if(size == 1){
            itemN = null;
            item0 = null;
        }
        T itemN = node.getItem();
        node.removeSelf();
        size--;
        return itemN;
    }

    public int getSize() {
        return size;
    }

    public LinkedListNode addItemToCache(T item){

        LinkedListNode<T> newItem = new LinkedListNode<>(item);
        if (item0 == null){
            item0 = new LinkedListNode<>(item);
            itemN = item0;
        } else {
            newItem.setPrevItem(itemN);
            itemN.setNextItem(newItem);
            if (size == 1){
                item0.setNextItem(newItem);
            }
            itemN = newItem;
        }
        size++;
        System.out.println(itemN);
        return newItem;
    }

    public List<T> getAll(){

        List<T> listOut = new ArrayList<>();
        LinkedListNode tempItem = item0;
        for (int i = 0; i<size;i++){
            listOut.add((T)tempItem.getItem());
                tempItem = tempItem.getNextItem();
        }
        return listOut;
    }

    public void getNodeToEnd(LinkedListNode node){


        removeNode(node);
        addItem((T)node.getItem());
//
//        if (node.getPrevItem() != null && node.getNextItem() != null){
//            node.getPrevItem().setNextItem(node.getNextItem());
//            node.getNextItem().setPrevItem(node.getPrevItem());
//        } else if (node.getPrevItem() != null){
//
//            System.out.println("last");
//        } else {
//            System.out.println("first");
//        }
//
//
//        if (node != itemN){
//        itemN.setNextItem(node);
//        node.setPrevItem(itemN);
//        itemN = node;
//        itemN.setNextItem(null);}

    }
}

