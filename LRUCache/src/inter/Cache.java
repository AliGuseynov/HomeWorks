package inter;

public interface Cache <V, T>{
    T get(V key);

    void put(V key, T val);
    void removeOld();
    void printAllValues();
}
