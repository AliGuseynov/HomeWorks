import CacheV2.CacheControllerV2;
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
        CacheControllerV2 cacheController = new CacheControllerV2(3);


        cacheController.addItem("1");
        cacheController.addItem("2");
        cacheController.addItem("3");
        cacheController.addItem("4");
        cacheController.addItem("3");
        System.out.println("=======");
        cacheController.printAll();
        System.out.println("=======");
//        System.out.println(cacheController.getElement(0));
//        System.out.println("=======");
//        cacheController.printAll();


        ///////////////////////////////////////
//        System.out.println("Task 2 ============================");
        //Task 2

        MyLinkedList linkedList = new MyLinkedList();

        // addItem ==============
//        linkedList.addItem(123);
//        linkedList.addItem("Jamal");
//        linkedList.addItem("Jamal");
//        linkedList.addItem("To remove");
//        linkedList.addItem("Test 2");

        // remove index ==============
//        System.out.println(linkedList.removeIndex(1) + " deleted");


        // get index ==============
//        System.out.println("Search result = " + linkedList.getElementAtIndex(1));


        // get item ==============
//        System.out.println("search id " + linkedList.findItem(" "));

        Ui ui = new Ui(cache, linkedList, cacheController);
        ui.run();
    }
}