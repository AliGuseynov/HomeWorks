package homeworks.homework16.task1.MyLinkedList;

public class ListNode {
    int value;
    ListNode next;
    ListNode prev;

    public ListNode(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString() {
        return "[" + "value=" + value + ","+ "next=" + next + "]";
    }
}
