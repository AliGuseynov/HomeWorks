import cache.CacheController;
import linkedList.MyLinkedList;
import ui.Ui;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        ///////////////////////////////////////
//        System.out.println("Task 1 ============================");
        //Task 1

        CacheController cache = new CacheController(5);

//        cache.addData(132);
//        cache.addData("Test data 123");
//        cache.addData("Test data two");
//        System.out.println(cache.getElement(1));
//        System.out.println(cache.getElement(13));
//
//        System.out.println("All data");
//        cache.getAll();


        ///////////////////////////////////////
//        System.out.println("Task 2 ============================");
        //Task 2

        MyLinkedList linkedList = new MyLinkedList();

        // addItem ==============
//        linkedList.addItem(123);
//        linkedList.addItem("Jamal");
//        linkedList.addItem("To remove");
//        linkedList.addItem("Test 2");

//        linkedList.getAllItems();

        // remove index ==============
//        linkedList.removeIndex(0);

        // get index ==============
//        System.out.println("Result" + linkedList.get(1));


        // get item ==============
//        System.out.println(linkedList.findItem("Jamal"));

        Ui ui = new Ui(cache, linkedList);
        ui.run();
    }
}