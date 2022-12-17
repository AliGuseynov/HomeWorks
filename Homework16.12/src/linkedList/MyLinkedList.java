package linkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MyLinkedList <T>{


//    private GenericLinkedlistClass[] LinkedList;
//
//
//
//    public void addItem(GenericLinkedlistClass item){
//        GenericLinkedlistClass[] tempArray = new GenericLinkedlistClass[LinkedList.length+1];
//
//
//    }


    List <GenericLinkedlistClass> LinkedList = new ArrayList<>();

    private GenericLinkedlistClass item0;
    boolean ListStarted = false;

    private Integer startLocation = 0;

    public void addItem(T item){
        ListStarted = true;
        GenericLinkedlistClass lastItem = findLastItem();

        if (lastItem == null){
            lastItem = new GenericLinkedlistClass(item);
            item0 = lastItem;
        } else {
            lastItem.setNextItem(new GenericLinkedlistClass(item));
        }

//        System.out.println(lastItem.getItem());
    }

    public T get(Integer index){
        GenericLinkedlistClass ListItem = item0;
        T item = (T)item0.getItem();

        for (int i = 0; i<index; i++){
            item = (T)ListItem.getItem();
            ListItem = ListItem.getNextItem();
        }

        return item;
    }

    public void removeIndex(Integer index){

        GenericLinkedlistClass ListItem = item0;
        GenericLinkedlistClass PrevItem = null;
        boolean delete = false;

        if (item0 != null) {
            for (int i = 0; i < index; i++) {
                PrevItem = ListItem;
                if (ListItem.getNextItem() != null) {
                    ListItem = ListItem.getNextItem();
                    delete = true;
                } else {
                    delete = false;
                    break;
                }
            }
            if (delete){
            System.out.println(ListItem.getItem() + " Removed");
            PrevItem.setNextItem(ListItem.getNextItem());}
            else {System.out.println("Item at index is not exists");}
        } else System.out.println("Item at index is not exists");
    }

    public Integer findItem(T item){
        Integer findIndex = 0;
        GenericLinkedlistClass ListItem = item0;

        while (ListItem != null){

            if (ListItem.getItem() == item){
                return findIndex;
            } else {
                ListItem = ListItem.getNextItem();

                findIndex++;
            }
        }


        return -1;
    }

    private GenericLinkedlistClass findLastItem(){
        GenericLinkedlistClass foundItem = item0;

        if (ListStarted){
        boolean search = true;
        while (search){

            if (foundItem != null && foundItem.getNextItem() != null){
                foundItem = foundItem.getNextItem();
            } else {
                search = false;
                return foundItem;
            }
        }
        return foundItem;
    }else {
            return item0;
        }}








    }


