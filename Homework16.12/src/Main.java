import linkedList.MyLinkedList;

import java.util.List;

public class Main {
    public static void main(String[] args) {

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