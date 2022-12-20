

public class Node<T> {
    public Node(T price) {
        this.price = price;
    }

    T price;
    Node next;
    Node prev;

    @Override
    public String toString() {
        return "Node{" +
                "price=" + price +
                ", next=" + next +
                ", prev=" + prev +
                '}';
    }

    public T getPrice() {
        return price;
    }

    public void setPrice(T price) {
        this.price = price;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
