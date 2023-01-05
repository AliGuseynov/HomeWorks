package com.company;

public class MyLinkedList<T> {


    class Node {
        T val;
        Node next;

        Node(T val) {
            this.val = val;
        }
    }

        private Node head;
        private Node tail;

        //ADD to the beginning
        public void addFirst(T val){
            if(isEmpty()){
                head = new Node(val);
                tail = head;
                return;
            }
            Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;

        }

        //ADD to the end
        public void addLast(T val){
            if(isEmpty()){
                head = new Node(val);
                tail = head;
                return;
            }
            Node newNode = new Node(val);
            tail.next = newNode;
            tail = newNode;
        }

        //REMOVE item at the given index
        public T delete(int index){
            if(isEmpty()) {
                throw new RuntimeException("List is empty. ");
            }
            Node current = head;
            Node prev = null;
            int count = 1;
            while(count < index){
                count++;
                prev = current;
                current = current.next;
            }
            prev.next = current.next;
            current.next = null;
            return current.val;
        }

        //FIND
        public boolean search(T val){
            Node current = head;
            while(current != null){
                if(val == current.val){
                    return true;
                }
                current = current.next;
            }
            return false;
        }


        public boolean isEmpty(){
            return head == null;
        }

        public void print(){
            Node current = head;

            while(current != null){
                System.out.print(current.val + " | ");
                current = current.next;
            }
            System.out.println();
        }


}
