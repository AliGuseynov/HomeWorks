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

    public LinkedListNode getNodeAtIndex(int index){
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
        for (int i = 0; i < size ;i++){
            listOut.add((T)tempItem.getItem());
                tempItem = tempItem.getNextItem();
        }
        return listOut;
    }

    public void getNodeToEnd(LinkedListNode node){
        removeNode(node);
        addItem((T)node.getItem());
    }

    public LinkedListNode moveNode(boolean direction, LinkedListNode node){ //true if forward

        LinkedListNode nextNode = null;
        LinkedListNode next2Node = null;



        if (direction){ // moving towards 0
            if (node.getPrevItem() != null){
                nextNode = node.getPrevItem();

                if (node.getPrevItem().getPrevItem() != null) {
                    next2Node = nextNode.getPrevItem();
                }
            }

            if (nextNode == null){
                item0 = node;
                return node;
            } else {
                if (node.getNextItem() != null){

                    if (node.getNextItem() != null){
                        nextNode.setNextItem(node.getNextItem());
                    } else { nextNode.setNextItem(null);
                    itemN = nextNode;}

                    nextNode.setPrevItem(node);
                }
                if (next2Node == null){
                    item0 = node;
                    return node;
                } else {
                    next2Node.setNextItem(node);
                }

            }


        } else { // moving towards last recent added

            if (node.getNextItem() != null){
                nextNode = node.getNextItem();

                if (node.getNextItem().getNextItem() != null) {
                    next2Node = nextNode.getNextItem();
                }
            }

            if (nextNode == null){
                itemN = node;
                return node;
            } else {
                if (node.getPrevItem() != null){
                    if (node.getPrevItem() != null){
                        nextNode.setPrevItem(node.getPrevItem());
                    } else {
                        nextNode.setPrevItem(null);
                        item0 = nextNode;
                    }

                    nextNode.setNextItem(node);
                }
                if (next2Node == null){
                    itemN = node;
                    return node;
                } else {
                    next2Node.setPrevItem(node);
                }
            }}

        return node;
    }
}

