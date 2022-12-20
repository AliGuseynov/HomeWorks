package cache;

public interface Cache<V,T> {

    T get(V key);

    void put(V key, T value);

    void remove();

    void printAllKeys();
}
