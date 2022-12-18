package homeworks.homework16.task22;

public class MyLinkedList<T> {

    Node head;

    public void add(T item) {
        Node node = new Node();
        node.item = item;
        node.next = null;

        if (head == null) {
            head = node;
        } else {
            Node node1 = head;

            while (node1.next != null) {
                node1 = node1.next;
            }
            node1.next = node;
        }

    }

    public void get(int index, T data) {
        Node node = new Node();
        node.item = data;
        node.next = null;
        Node n = head;
        for (int i = 0; i < index - 1; i++) {
            n = n.next;

        }
        node.next = n.next;
        n.next = node;


    }

    public void remove(int index) {
        if (index == 0) {
            head = head.next;
        } else {
            Node n = head;
            Node n2 = null;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;

            }
            n2 = n.next;
            n.next = n2.next;
            n2 = null;
        }
    }

//    public void find(int item) {
//        Node current = head;
//        while (current != null) {
//            if(item==current.item){
//                System.out.println();
//            }
//        }
//    }


    public void print() {
        Node node = head;

        while (node.next != null) {
            System.out.println(node.item);
            node = node.next;
        }
        System.out.println(node.item);
    }
}