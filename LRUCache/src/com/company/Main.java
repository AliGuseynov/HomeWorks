package com.company;

public class Main {

    public static void main(String[] args) {
	  LRUCache cache = new LRUCache();
      cache.addElement(1);
        cache.addElement("two");
        cache.addElement(3);
        cache.addElement("four");
        cache.addElement(5);
        cache.addElement("six");
        System.out.println(cache.printAll());

        System.out.println("\nFirst: " + cache.getElement( 0));
        System.out.println("Second: " + cache.getElement( 1));
        System.out.println("Third: " + cache.getElement( 2));

    }
}
