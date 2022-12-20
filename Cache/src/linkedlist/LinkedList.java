package linkedlist;

public class LinkedList<T> {
    public Node<T> head;

    public int count;

    public Node<T> last;

    public Node<T> previous;


    public LinkedList(){
        this.head = null;
        this.count = 0;
    }

    @Override
    public String toString() {
        return "MyLinkedList: [" +  head + "]";
    }

    //Bu hisse duz ishlemir umumiliyyetle ishlemir nese alemi vurmusam
    public void add(T item){
        if (head == null){
            head = new Node<>(item);
            last = head;
        } else {
            Node<T> node = new Node<>(item);
            node.previous(last);
            last.next(last);
            if (count == 1){
                head.next(node);
            }
            last = node;
        }
        count++;
//        Node node = new Node(item);
//
//        if (head == null){
//            head = node;
//            last = node;
//            previous=node;
//        }else {
//            last.next = node;
//            last = node;
//            last.previous=node;
//        }
//        count++;
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
    public int find(T item){
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
    public int size(){
        return count;
    }

    public void printAll(){
        System.out.println(this.head);
    }

}
