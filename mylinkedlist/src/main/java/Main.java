public class Main {
    public static void main(String[] args) {
        String node = new String(new char[10]).replace("\0", "-");
        ListManager listManager = new ListManager();

        ///---> add element<---\\\
        listManager.listFirstAdd(120);
        listManager.listLastAdd(962);
        listManager.listFirstAdd(632);
        listManager.listFirstAdd(317);
        ///---> print all elements<---\\\
        System.out.println("formed nodes : " + node);
        System.out.print("Linked List Data which I determined :");
        listManager.listWrite();
        listManager.listLastAdd(149);
        listManager.listFirstAdd(829);
        System.out.print(" \nLinked List with newly added elements: ");
        listManager.listWrite();

    }
}
