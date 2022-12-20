package linkedlist;

public class Node<T> {
    public Node previous;
    public Node next;
    public T data;

    public Node() {
    }

    public Node(T data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "Node{" +
                "previous=" + previous +
                ", next=" + next +
                ", data=" + data +
                '}';
    }
}
