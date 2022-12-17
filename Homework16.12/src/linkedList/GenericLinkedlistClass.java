package linkedList;

public class GenericLinkedlistClass <T>{
    private T item;

    private GenericLinkedlistClass nextItem = null;

    public GenericLinkedlistClass getNextItem() {
        return nextItem;
    }

    public void setNextItem(GenericLinkedlistClass nextItem) {
        this.nextItem = nextItem;
    }

    public T getItem() {
        return (T)item;
    }

    public GenericLinkedlistClass(T item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return item.toString();
    }
}
