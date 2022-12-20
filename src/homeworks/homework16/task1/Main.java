package homeworks.homework16.task1;

import homeworks.homework16.task1.MyLinkedList.DoublyLinkedList;
import homeworks.homework16.task1.MyLinkedList.ListNode;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        LRUCache<String, String> lruCache = new LRUCache<>(5);
//        lruCache.put("Test1", "Test1");
//        Thread.sleep(10);
//        lruCache.put("Test2", "Test2");
//        Thread.sleep(10);
//        lruCache.put("Test3", "Test3");
//        Thread.sleep(10);
//        lruCache.put("Test4", "Test4");
//        Thread.sleep(10);
//        lruCache.put("Test5", "Test5");
//        Thread.sleep(10);
//
//        lruCache.put("Test1", "Test1");
//        Thread.sleep(10);
//
//        lruCache.get("Test2");
//        Thread.sleep(10);
//        lruCache.put("Test6", "Test6");
//        Thread.sleep(10);
//        lruCache.printAllKeys();


        DoublyLinkedList linkedList = new DoublyLinkedList();


        linkedList.addBefore(new ListNode(5));
        linkedList.addBefore(new ListNode(2));
        linkedList.addBefore(new ListNode(6));
        linkedList.addBefore(new ListNode(7));
        linkedList.addBefore(new ListNode(2));
        linkedList.show();


        linkedList.addLast(new ListNode(8));
        linkedList.show();

        linkedList.deleteBefore();
        linkedList.show();

        linkedList.deleteLast();
        linkedList.show();



    }
}
