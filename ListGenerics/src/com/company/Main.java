package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        MyLinkedList test = new MyLinkedList();

        test.addFirst("third");
        test.addFirst("2nd");
        test.addFirst(1);

        System.out.print("After adding 3 items to the beginning: ");
        test.print();

        test.addLast(4);
        test.addLast("fifth");

        System.out.print("\nAfter adding 2 items to the end: ");
        test.print();

        test.delete(3);
        System.out.print("\nAfter deleting 3rd element: ");
        test.print();

        System.out.println("\nSearch for 'sixth': ");
        System.out.println(test.search("sixth"));


        System.out.println("\nSearch for 4: ");
        System.out.println(test.search(4));
    }
}
