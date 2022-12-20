package impl;

public class Node<T> {
    public Node next;
    public T data;

    @Override
    public String toString() {
        return  data + "," + (next != null ? next.toString() : "");
    }

    public Node(T data) {
        this.data = data;
    }
    public void setNext(Node next){
        this.next = next;
    }
    public Node getNext(){
        return this.next;
    }
}
