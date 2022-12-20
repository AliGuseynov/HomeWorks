package impl;

import inter.MyLinkedListInter;

public class MyLinkedList <T> implements MyLinkedListInter {
    public Node<T> head ;
    public int count;
    public Node<T> last;

    public MyLinkedList(){
        this.head = null;
        this.count = 0;
    }
    @Override
    public String toString() {
        return "impl.MyLinkedList: [" +  head + "]";
    }



    @Override
    public void add(Object item) {
        Node node = new Node(item);

        if (head == null){
            head = node;
            last = node;
        }else {
            last.next = node;
            last = node;
        }
        count++;
    }

    public T getByIndex(int index){
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node.data;
    }

    public void remove(int index){
        Node<T> node = head;

        for (int i = 0; i < index-1; i++) {
            node = node.next;
        }
        if(index == 0){
            head = head.next;
        }else{
            node.next = node.next.next;
        }
        count --;

    }

    @Override
    public int find(Object item) {
        Node node = head;
        boolean found = false;
        int count = -1;
        while (!item.equals(node.data)){
            node = node.next;
            count++;
            found = true;
        }
        return found ? count : -1;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
