public class Main {
    public static void main(String[] args) {
        LinkedList<String> myLinkedList = new LinkedList();
        for (int i = 0; i < 10; i++) {
            myLinkedList.add("Salam" + i);
        }
        System.out.println(myLinkedList);
//        System.out.println(myLinkedList.size());
        myLinkedList.delete(0);
        System.out.println(myLinkedList);
//        System.out.println(myLinkedList.size());
        System.out.println(myLinkedList.get(5));
//        System.out.println(myLinkedList.f("Salam7"));

    }
}
