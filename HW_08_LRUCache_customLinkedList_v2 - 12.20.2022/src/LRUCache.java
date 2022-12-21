import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LRUCache<T> {

    private int capacity;
    private int size;
    private HashMap<Integer, Node> cache;
    private Node head, tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);

        head = new Node();
        tail = new Node();

        head.setNext(tail);
        tail.setPrev(head);
    }

    public T get(int key) {

        Node node = cache.get(key);

        if (node == null)
            return null;

        remove(node);
        moveToHead(node);
        return (T) node.getData();
    }

    public void put(int key, T data) {

        Node newNode = cache.get(key);

        if (newNode != null) {

            newNode.setData(data);
            remove(newNode);
            moveToHead(newNode);

        } else {

            newNode = new Node();

            newNode.setKey(key);
            newNode.setData(data);

            cache.put(key, newNode);
            moveToHead(newNode);

            size++;

            if (capacity <= size) {

                cache.remove(tail.getPrev().getKey());
                remove(tail.getPrev());
                size--;
            }
        }
    }

    public void moveToHead(Node node) {
        Node tmp = head.getNext();

        head.setNext(node);

        node.setNext(tmp);
        node.setPrev(head);

        tmp.setPrev(node);
    }

    public void remove(Node node) {
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
    }
}
