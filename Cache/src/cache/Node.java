package cache;

import java.time.LocalDateTime;

public class Node<T> {
    private T value;
    private LocalDateTime time;

    private int count;
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Node() {
    }

    public Node(T value, LocalDateTime time) {
        this.value = value;
        this.time = time;
    }

    public Node(T value, int count) {
        this.value = value;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
