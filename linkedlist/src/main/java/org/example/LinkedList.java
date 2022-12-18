package org.example;

public class LinkedList<Value> {

    class Node {
        Value val;
        Node next;

        Node(Value val){
            this.val = val;
        }
    }

    private Node head;
    private Node tail;

    public void addFirst(Value val){
        if(isEmpty()) {
            head = new Node(val);
            tail = head;
            return;
        }
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(Value val){
        if(isEmpty()) {
            head = new Node(val);
            tail = head;
            return;
        }
        Node newNode = new Node(val);
        tail.next = newNode;
        tail = newNode;
    }

    public void add(int pos, Value val){
        // validate pos using size
        if( pos == 1 ){
            addFirst(val);
            return;
        }
        Node current = head;
        int count = 1;
        while(count < pos-1) {
            count++;
            current = current.next;
        }
        Node newNode = new Node(val);
        newNode.next = current.next;
        current.next = newNode;
    }

    public Value deleteFirst(){
        if(isEmpty()) {
            throw new RuntimeException("List is Empty");
        }
        Node current = head;
        head = head.next;
        current.next = null;
        if(isEmpty()) {
            tail = null;
        }
        return current.val;
    }

    public Value deleteLast() {
        if(isEmpty()) {
            throw new RuntimeException("List is Empty");
        }
        if(head == tail) {
            Value val = head.val;
            head = null;
            tail = null;
            return val;
        }
        Node current = head;
        Node prev = null;

        while (current.next != null){
            prev = current;
            current = current.next;
        }
        prev.next = null;
        tail = prev;
        return current.val;
    }

    public Value delete(int pos){
        if(isEmpty()) {
            throw new RuntimeException("List is Empty");
        }
        if(pos == 1) {
            deleteFirst();
        }
        Node current = head;
        Node prev = null;
        int count = 1;

        while(count < pos) {
            count++;
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
        current.next = null;
        return current.val;
    }

    public boolean search(Value val){
        Node current = head;
        while(current != null){
            if(val == current.val) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean isEmpty(){
        return head == null ;
    }


    public void print(){
        Node current = head;
        while(current != null){
            System.out.print(current.val +" -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }

    // Driver Method
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList();

        ll.addFirst(20);
        System.out.print("After Adding 20 at First : ");
        ll.print();

        ll.addFirst(10);
        System.out.print("After Adding 10 at First : ");
        ll.print();

        ll.addLast(30);
        System.out.print("After Adding 30 at Last  : ");
        ll.print();

        ll.addLast(40);
        System.out.print("After Adding 40 at Last  : ");
        ll.print();

        ll.addFirst(5);
        System.out.print("After Adding  5 at First : ");
        ll.print();

        ll.add(4, 25);
        System.out.print("After Adding 25 at Pos 4 : ");
        ll.print();

        ll.deleteFirst();
        System.out.print("After Deleting First Node: ");
        ll.print();

        ll.deleteLast();
        System.out.print("After Deleting Last Node : ");
        ll.print();

        ll.delete(3);
        System.out.print("After Deleting Node at pos 3 : ");
        ll.print();

        LinkedList<String> ll1 = new LinkedList();
        ll1.addFirst("One");
        ll1.addLast("Two");
        ll1.print();

        System.out.println(ll1.search("One"));

    }
}