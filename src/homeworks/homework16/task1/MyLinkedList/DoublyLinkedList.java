package homeworks.homework16.task1.MyLinkedList;

public class DoublyLinkedList {
    int size;
    ListNode head;
    ListNode tail;

    public DoublyLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public void addBefore(ListNode node) {
        if (head == null) {
            tail = node;
        } else {
            head.prev = node;
            node.next = head;
        }
        head = node;
        size++;
    }

    public void addLast(ListNode node) {
        if (head == null) {
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
        size++;
    }


    public void deleteBefore() {
        if (head == null) {
            System.out.println("List boshdur");
        } else {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head.next.prev = null;
                head = head.next;

            }
            size--;
        }
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("List boshdur");
        } else {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail.prev.next = null;
                tail = tail.prev;
            }
        }
        size--;

    }


    public void show() {
        System.out.println(this.head);
    }

}


