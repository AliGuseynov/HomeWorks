package az.company;

import az.company.models.LRUCache;

public class Main {
    public static void main(String[] args) {
        LRUCache ca = new LRUCache(3);
        ca.refer(1);
        ca.refer(2);
        ca.refer(3);
        ca.refer(1);
        ca.refer(4);
        ca.refer(5);
        ca.refer(1);
        ca.getAll();


    }
}
