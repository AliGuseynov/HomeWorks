package homeworks.homework16.task2;


public class Main {
    public static void main(String[] args) {

//        LinkedList linkedList = new LinkedList();
      MyLinkedList<Integer> myLinkedList = new MyLinkedList();
        myLinkedList.add(18);
        myLinkedList.add(39);
        myLinkedList.add(28);
        myLinkedList.add(199);


//        myLinkedList.get(2,1000);
        myLinkedList.remove(3);


        myLinkedList.print();

    }
//
}
