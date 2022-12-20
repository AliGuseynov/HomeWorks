package inter;

public interface MyLinkedListInter<T> {
    void add(T item);
    T getByIndex(int index);
    void remove(int index);
    int find(T item);
}
