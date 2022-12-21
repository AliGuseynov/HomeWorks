import cache.CacheControllerLFU;
import cache.CacheControllerLRU;
import linkedList.MyLinkedList;
import ui.Ui;

public class Main {
    public static void main(String[] args) {

        ///////////////////////////////////////
//        System.out.println("Task 1 ============================");
        //Task 1

        CacheControllerLRU cacheController = new CacheControllerLRU(3);

        CacheControllerLFU cacheControllerLFU = new CacheControllerLFU<>(3);


//        cacheController.addItem("1");
//        cacheController.addItem("2");
//        cacheController.addItem("3");
//        cacheController.addItem("4");
//        cacheController.addItem("3");
//        System.out.println("=======");
//        cacheController.printAll();
//        System.out.println("=======");
//        System.out.println(cacheController.getElement(0));
//        System.out.println("=======");
//        cacheController.printAll();

        cacheControllerLFU.addItem("1");
        cacheControllerLFU.addItem("2");
        cacheControllerLFU.addItem("3");
        cacheControllerLFU.addItem("1");
//        cacheControllerLFU.getElement(1);
//        cacheControllerLFU.addItem("4");
//        cacheControllerLFU.addItem("3");
        cacheControllerLFU.printAll();



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

        Ui ui = new Ui(linkedList, cacheController);
        ui.run();

    }
}