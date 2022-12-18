import cache.CacheController;
import linkedList.MyLinkedList;

public class Main {
    public static void main(String[] args) {

        ///////////////////////////////////////
        System.out.println("Task 1 ============================");
        //Task 1

        CacheController cache = new CacheController(5);

        cache.addData(132);
        cache.addData("Test data 123");
        cache.addData("Test data two");
        System.out.println(cache.getElement(1));
        System.out.println(cache.getElement(13));

        System.out.println("All data");
        cache.getAll();


        ///////////////////////////////////////
        System.out.println("Task 2 ============================");
        //Task 2

        MyLinkedList linkedList = new MyLinkedList();

        // addItem ==============
        linkedList.addItem(123);
        linkedList.addItem("Jamal");
        linkedList.addItem("To remove");

        // get index ==============
        System.out.println("Result" + linkedList.get(1));

        // remove index ==============
        linkedList.removeIndex(2);

        // get item ==============
        System.out.println(linkedList.findItem("Jamal"));

    }
}