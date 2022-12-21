public class CustomLinkedList <T> {

    private int size = 0;
    private Node head;

    public CustomLinkedList() {
    }

    public void add(T data) {

        Node newNode = new Node(data);

        if (this.head == null) {

            head = newNode;
        } else {

            Node currentNode = head;

            while (currentNode.getNextNode() != null)
                currentNode = currentNode.getNextNode();

            currentNode.setNextNode(newNode);
        }

        size++;
    }

    public void remove(int index) {
        Node node = head;



        for (int i = 0; i < index - 1; i++)
            node = node.getNextNode();

        node.setNextNode(node.getNextNode().getNextNode());
        size--;
    }

    public T get(int index) {
        Node node = head;

        for (int i = 0; i < index; i++)
            node = node.getNextNode();

        return (T) node.getData();
    }

    public int find(T data) {
        Node node = head;

        for (int i = 0; i < size; i++) {
            if (node.getData() == data)
                return i;
            else
                node = node.getNextNode();
        }

        return -1;
    }

    public int getSize() {
        return size;
    }
}