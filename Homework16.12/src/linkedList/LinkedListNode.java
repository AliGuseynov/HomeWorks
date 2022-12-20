package linkedList;

public class LinkedListNode<T>{
    private T item;

    private LinkedListNode<T> nextItem = null;

    private LinkedListNode<T> prevItem = null;

    public LinkedListNode getNextItem() {
        return nextItem;
    }

    public void setNextItem(LinkedListNode nextItem) {
        this.nextItem = nextItem;
    }

    public T getItem(){
        T itemout = item;
        return itemout;
    }

    public LinkedListNode(T item) {
        this.item = item;
    }

    @Override
    public String toString() {
        String prevItemToShow = null;
        String nextItemToShow = null;
        if (prevItem != null){
            prevItemToShow = prevItem.getItem().toString();
        }
        if (nextItem != null){
            nextItemToShow = nextItem.getItem().toString();
        }
        return " Item = " + item.toString() + " Prev item " + prevItemToShow + " Next item " + nextItemToShow;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public LinkedListNode getPrevItem() {
        return prevItem;
    }

    public void setPrevItem(LinkedListNode prevItem) {
        this.prevItem = prevItem;
    }

    public void removeSelf(){
        if (prevItem != null){
            prevItem.setNextItem(getNextItem());
        }
        if (nextItem != null){
            nextItem.setPrevItem(getPrevItem());
        }
    }

}
