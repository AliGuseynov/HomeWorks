package service;

import impl.MyLinkedList;
import inter.MyLinkedListInter;

public class MyLinkedListService {
    MyLinkedList myLinkedList=new MyLinkedList();
    public void add(Object item){
        myLinkedList.add(item);
    }
    public void remove(int index){
        myLinkedList.remove(index);
    }
    public void getByIndex(int index){
        myLinkedList.getByIndex(index);
    }
    public void find(Object item){
myLinkedList.find(item);
    }
    public void printAll(){
        System.out.println(myLinkedList.getHead());
    }
    public void size(){
        System.out.println(myLinkedList.getCount());
    }
}
